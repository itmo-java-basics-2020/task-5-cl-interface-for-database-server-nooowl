package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class CreateTableCommand implements DatabaseCommand {
    private String databaseName;
    private String tableName;
    private ExecutionEnvironment executionEnvironment;

    public CreateTableCommand(ExecutionEnvironment executionEnvironment, String databaseName, String tableName) {
        this.executionEnvironment = executionEnvironment;
        this.databaseName = databaseName;
        this.tableName = tableName;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Database database = executionEnvironment.getDatabase(databaseName).orElseThrow();
        database.createTableIfNotExists(tableName);
        return DatabaseCommandResult.success();
    }
}
