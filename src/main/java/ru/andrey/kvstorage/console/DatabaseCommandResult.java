package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS,
        FAILED
    }

    static DatabaseCommandResult success(String result) {
        return new DatabaseCommandResultImpl(DatabaseCommandStatus.SUCCESS, result);
    }

    static DatabaseCommandResult success() {
        return success(null);
    }

    static DatabaseCommandResult failed(String errorMessage) {
        return new DatabaseCommandResultImpl(DatabaseCommandStatus.FAILED, null, errorMessage);
    }

    class DatabaseCommandResultImpl implements DatabaseCommandResult {
        private DatabaseCommandStatus status;
        private String result;
        private String errorMessage;

        private DatabaseCommandResultImpl(DatabaseCommandStatus status, String result, String errorMessage) {
            this.status = status;
            this.result = result;
            this.errorMessage = errorMessage;
        }

        private DatabaseCommandResultImpl(DatabaseCommandStatus status, String result) {
            this(status, result, null);
        }

        private DatabaseCommandResultImpl(DatabaseCommandStatus status) {
            this(status, null);
        }

        @Override
        public Optional<String> getResult() {
            return Optional.ofNullable(result);
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return status;
        }

        @Override
        public boolean isSuccess() {
            return status == DatabaseCommandStatus.SUCCESS;
        }

        @Override
        public String getErrorMessage() {
            return errorMessage;
        }
    }
}