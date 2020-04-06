package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.DatabaseCommandResult;

public class Results {
    public static DatabaseCommandResult success(String result) {
        return new DatabaseCommandResult.DatabaseCommandResultImpl(
                DatabaseCommandResult.DatabaseCommandStatus.SUCCESS, result);
    }

    public static DatabaseCommandResult success() {
        return success(null);
    }

    public static DatabaseCommandResult failed(String errorMessage) {
        return new DatabaseCommandResult.DatabaseCommandResultImpl(
                DatabaseCommandResult.DatabaseCommandStatus.FAILED, null, errorMessage);
    }
}
