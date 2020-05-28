package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {
    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        if (commandText == null) {
            return DatabaseCommandResult.failed("Command text can't be null");
        }
        String[] splitCommand = commandText.split("\\s+");

        DatabaseCommands databaseCommand;
        try {
            databaseCommand = DatabaseCommands.valueOf(splitCommand[0]);
            String[] args = new String[0];
            if (splitCommand.length > 1) {
                args = Arrays.copyOfRange(splitCommand, 1, splitCommand.length);
            }
            return databaseCommand.getCommand(env, args).execute();
        } catch (DatabaseException | IllegalArgumentException | NoSuchElementException e) {
            return DatabaseCommandResult.failed(e.getMessage());
        }
    }
}
