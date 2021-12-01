package client.model.socketSender;

import client.model.socketSender.impl.SocketSenderImpl;

import java.net.InetAddress;

public class SocketSenderFactory {
    public static SocketSender getSocketSender(InetAddress address, int port) {
        return new SocketSenderImpl(address, port);
    }

    private SocketSenderFactory() {
    }
}