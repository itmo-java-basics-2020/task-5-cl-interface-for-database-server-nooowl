package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.Results;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

public class CreateDatabaseCommand implements DatabaseCommand {
    private String databaseName;
    private ExecutionEnvironment executionEnvironment;

    public CreateDatabaseCommand(ExecutionEnvironment env, String databaseName) {
        this.databaseName = databaseName;
        this.executionEnvironment = env;
    }

    @Override
    public DatabaseCommandResult execute() {
        return Results.success();
    }
}
