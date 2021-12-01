package client.model.socketSender;

import domain.request.Request;
import domain.response.Response;

public interface SocketSender {
    Response send(Request request) throws Exception;
}
