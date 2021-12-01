package server.view;

import domain.ConsoleScanner;
import domain.Logger;
import server.dao.DaoException;
import server.dao.account.AccountDaoFactory;
import server.dao.record.StudentRecordDaoFactory;
import server.view.impl.MultithreadSocketListenerImpl;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    private static final String SHUTDOWN_KEYWORD = "shutdown";

    public static void main(String[] args) {
        MultithreadSocketListenerImpl listener;
        Thread listenerThread;

        if (args.length < 3) {
            Logger.log(new ViewException("At least 3 arguments needed: port, account file path and records file path"));
            return;
        }

        if (args.length > 3) {
            try {
                Logger.setErrorStream(new PrintStream(args[3]));
            } catch (FileNotFoundException e) {
                Logger.log(new ViewException("Error setting error stream", e));
                return;
            }
        }

        try {
            AccountDaoFactory.getDao().loadFrom(args[0]);
            StudentRecordDaoFactory.getDao().loadFrom(args[1]);
        } catch (DaoException e) {
            Logger.log(e);
            return;
        }

        try {
            listener = new MultithreadSocketListenerImpl(Integer.parseInt(args[2]));
        } catch (IllegalArgumentException e) {
            Logger.log(e);
            return;
        }

        listenerThread = new Thread(listener);
        listenerThread.start();

        while (!ConsoleScanner.getNonEmptyString().equals(SHUTDOWN_KEYWORD))
            ;

        listener.stopListen();
        listener.waitForStop();
        try {
            listenerThread.join();
        } catch (InterruptedException e) {
            Logger.log(new ViewException("Iterrupted while joining listener thread", e));
        }
    }
}
