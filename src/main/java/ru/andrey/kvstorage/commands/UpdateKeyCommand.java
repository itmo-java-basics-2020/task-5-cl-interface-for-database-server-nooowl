package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.Results;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class UpdateKeyCommand implements DatabaseCommand {
    private String databaseName;
    private String tableName;
    private String key;
    private String value;
    private ExecutionEnvironment executionEnvironment;

    public UpdateKeyCommand(
            ExecutionEnvironment executionEnvironment,
            String databaseName, String tableName,
            String key, String value) {
        this.executionEnvironment = executionEnvironment;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.key = key;
        this.value = value;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Database database = executionEnvironment.getDatabase(databaseName).orElse(null);
        if (database == null) {
            return Results.failed("No such database: " + databaseName);
        }
        executionEnvironment.getDatabase(databaseName);
        database.write(tableName, key, value);
        return Results.success();
    }
}
