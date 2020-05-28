package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class ReadKeyCommand implements DatabaseCommand {
    private String databaseName;
    private String tableName;
    private String key;
    private ExecutionEnvironment executionEnvironment;

    public ReadKeyCommand(ExecutionEnvironment executionEnvironment,
                          String databaseName, String tableName,
                          String key) {
        this.executionEnvironment = executionEnvironment;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.key = key;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Database database = executionEnvironment.getDatabase(databaseName).orElseThrow();
        return DatabaseCommandResult.success(database.read(tableName, key));
    }
}
