package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class CreateDatabaseCommand implements DatabaseCommand {
    private String databaseName;
    private ExecutionEnvironment executionEnvironment;

    public CreateDatabaseCommand(ExecutionEnvironment env, String databaseName) {
        this.databaseName = databaseName;
        this.executionEnvironment = env;
    }

    @Override
    public DatabaseCommandResult execute() {
        executionEnvironment.addDatabase(new Database() {
            @Override
            public String getName() {
                return databaseName;
            }

            @Override
            public void createTableIfNotExists(String tableName) throws DatabaseException {

            }

            @Override
            public void createTableIfNotExists(String tableName, int segmentSizeInBytes) throws DatabaseException {

            }

            @Override
            public void write(String tableName, String objectKey, String objectValue) throws DatabaseException {

            }

            @Override
            public String read(String tableName, String objectKey) throws DatabaseException {
                return null;
            }
        });
        return DatabaseCommandResult.success();
    }
}
