package shashev.Commands;

import shashev.Executor.ExecutionContext;

import java.util.List;

public class Print extends ExecutableCommand {

    public Print() {
        super("Print");
    }

    @Override
    public void execute(ExecutionContext context, List<String> inputArgs) {
        System.out.println(context.getStack().peek());
    }
}
