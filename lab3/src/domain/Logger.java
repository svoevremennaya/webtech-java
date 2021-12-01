package domain;

import java.io.PrintStream;

public class Logger {
    private static PrintStream loggerStream = System.err;

    private Logger() {
    }

    public static void log(Throwable throwable) {
        throwable.printStackTrace(loggerStream);
    }

    public static void log(String message) {
        loggerStream.println(message);
    }

    public static void setErrorStream(PrintStream stream) {
        loggerStream = stream;
    }
}
