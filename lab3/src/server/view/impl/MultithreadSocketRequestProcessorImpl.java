package server.view.impl;

import domain.Logger;
import server.controller.ControllerFactory;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.SocketException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadSocketRequestProcessorImpl implements SocketRequestProcessor, Runnable {
    private final BlockingQueue<SocketRequest> requests;
    private final ExecutorService threadPool;

    public MultithreadSocketRequestProcessorImpl(BlockingQueue<SocketRequest> requests) {
        if (requests == null) {
            throw new IllegalArgumentException("Requests shouldn't be null");
        }

        this.requests = requests;
        threadPool = Executors.newWorkStealingPool();
    }

    private void processRequest(SocketRequest socketRequest) {
        try {
            new ObjectOutputStream(socketRequest.getSocket().getOutputStream())
                    .writeObject(ControllerFactory.getController().process(socketRequest.getRequest()));
        } catch (IOException e) {
            Logger.log(new SocketException("Error acquiring output stream", e));
        } finally {
            try {
                socketRequest.getSocket().close();
            } catch (IOException e) {
                Logger.log(new SocketException("Error closing socket", e));
            }
        }
    }

    @Override
    public void start() {
        SocketRequest socketRequest;

        try {
            do {
                socketRequest = requests.take();

                if (socketRequest.getSocket() != null) {
                    SocketRequest finalSocketRequest = socketRequest;
                    threadPool.submit(() -> processRequest(finalSocketRequest));
                }
            } while (socketRequest.getSocket() != null);
        } catch (InterruptedException e) {
            Logger.log("Thread was interrupted while taking object from queue");
        }

        threadPool.shutdown();
        try {
            threadPool.awaitTermination(40, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Logger.log("Thread was interrupted while waiting for termination");
        }
    }

    @Override
    public void run() {
        start();
    }

}
