package server.controller;

import domain.account.UserRole;
import domain.request.RequestCode;
import server.command.impl.account.*;
import server.command.impl.record.*;

import java.util.HashMap;
import java.util.Map;

public class CommandMapFactory {
    private static final Map<UserRole, Map<RequestCode, Controller>> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put(null, getUnauthorizedCommands());
        commandMap.put(UserRole.ADMIN, getAdminCommands());
        commandMap.put(UserRole.USER, getUserCommands());
    }

    private static Map<RequestCode, Controller> getUnauthorizedCommands() {
        HashMap<RequestCode, Controller> result = new HashMap<>();

        result.put(RequestCode.ADD_ACCOUNT, new AddAccountCommandImpl());
        result.put(RequestCode.DOES_ACCOUNT_EXIST, new DoesAccountExistCommandImpl());
        result.put(RequestCode.LOGIN, new LoginCommandImpl());
        return result;
    }

    private static Map<RequestCode, Controller> getUserCommands() {
        HashMap<RequestCode, Controller> result = new HashMap<>();

        result.put(RequestCode.GET_ALL_RECORDS, new GetAllRecordsCommandImpl());
        result.put(RequestCode.GET_RECORDS_BY_GROUP, new GetRecordsByGroupCommandImpl());
        return result;
    }

    private static Map<RequestCode, Controller> getAdminCommands() {
        HashMap<RequestCode, Controller> result = new HashMap<>();

        result.put(RequestCode.GET_ALL_RECORDS, new GetAllRecordsCommandImpl());
        result.put(RequestCode.GET_RECORDS_BY_GROUP, new GetRecordsByGroupCommandImpl());
        result.put(RequestCode.ADD_ACCOUNT, new AddAccountCommandImpl());
        result.put(RequestCode.ADD_RECORD, new AddRecordCommandImpl());
        result.put(RequestCode.DELETE_RECORD, new DeleteRecordCommandImpl());
        result.put(RequestCode.UPDATE_RECORD, new UpdateRecordCommandImpl());
        result.put(RequestCode.UPDATE_ACCOUNT, new UpdateAccountCommandImpl());
        result.put(RequestCode.UPDATE_ACCOUNT_STORAGE, new UpdateAccountStorageCommandImpl());
        result.put(RequestCode.UPDATE_RECORD_STORAGE, new UpdateRecordStorageCommandImpl());
        return result;
    }

    public static Map<RequestCode, Controller> getCommands(UserRole userRole) {
        return new HashMap<>(commandMap.get(userRole));
    }

    private CommandMapFactory() {
    }
}
