package server.controller;

import server.controller.impl.ControllerImpl;

public class ControllerFactory {
    private static final Controller controller = new ControllerImpl();

    public static Controller getController() {
        return controller;
    }

    private ControllerFactory() {
    }
}
