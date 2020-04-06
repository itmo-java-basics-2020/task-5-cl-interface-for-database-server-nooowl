package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    public class DatabaseCommandResultImpl implements DatabaseCommandResult {
        private DatabaseCommandStatus status;
        private Optional<String> result;
        private String errorMessage;

        public DatabaseCommandResultImpl(DatabaseCommandStatus status, String result, String errorMessage) {
            this.status = status;
            this.result = Optional.ofNullable(result);
            this.errorMessage = errorMessage;
        }

        public DatabaseCommandResultImpl(DatabaseCommandStatus status, String result) {
            this(status, result, null);
        }

        public DatabaseCommandResultImpl(DatabaseCommandStatus status) {
            this(status, null);
        }

        @Override
        public Optional<String> getResult() {
            return result;
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