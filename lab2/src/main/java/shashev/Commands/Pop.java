package shashev.Commands;

import shashev.Executor.ExecutionContext;

import java.util.List;

public class Pop extends ExecutableCommand {

    public Pop() {
        super("Pop");
    }

    @Override
    public void execute(ExecutionContext context, List<String> inputArgs) {
        context.getStack().pop();
    }
}
