package server.controller;

import domain.request.Request;
import domain.response.Response;

public interface Controller {
    Response process(Request request);
}
