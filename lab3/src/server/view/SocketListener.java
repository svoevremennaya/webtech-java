package server.view;

public interface SocketListener {
    void startListen();

    void stopListen();

    void waitForStop();
}
