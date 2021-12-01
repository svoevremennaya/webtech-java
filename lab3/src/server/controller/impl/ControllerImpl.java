package server.controller.impl;

import domain.Logger;
import domain.account.UserRole;
import domain.request.Request;
import domain.request.RequestCode;
import domain.response.Response;
import domain.response.ResponseCode;
import server.command.Command;
import server.command.CommandException;
import server.controller.CommandMapFactory;
import server.controller.Controller;
import server.dao.DaoException;
import server.dao.account.AccountDaoFactory;

public class ControllerImpl implements Controller {
    @Override
    public Response process(Request request) {
        UserRole role;
        Command command;

        try {
            role = AccountDaoFactory.getDao().get(request.getRequest()).getRole();
        } catch (DaoException | IllegalArgumentException e) {
            role = null;
        }

        try {
            command = CommandMapFactory.getCommands(role).get(RequestCode.valueOf(request.getRequestCode()));
        } catch (IllegalArgumentException | NullPointerException e) {
            command = null;
        }
        if (command == null) {
            return new SerializableResponseImpl(ResponseCode.NO_SUCH_COMMAND.toString(), null);
        }

        try {
            return new SerializableResponseImpl(ResponseCode.SUCCESS.toString(),
                    command.execute(request.getRequestContent()));
        } catch (CommandException e) {
            Logger.log(e);
            return new SerializableResponseImpl(ResponseCode.INTERNAL_FAILURE.toString(), null);
        } catch (IllegalArgumentException e) {
            Logger.log(e);
            return new SerializableResponseImpl(ResponseCode.ILLEGAL_ARGUMENTS.toString(), null);
        }
    }
}
