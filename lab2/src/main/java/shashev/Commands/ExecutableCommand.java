package shashev.Commands;

import shashev.Executor.ExecutionContext;

import java.util.List;

public abstract class ExecutableCommand {

    protected final String commandName;

    public ExecutableCommand(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public abstract void execute(ExecutionContext context, List<String> inputArgs);
}
