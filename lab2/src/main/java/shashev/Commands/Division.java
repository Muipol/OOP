package shashev.Commands;

import shashev.Executor.ExecutionContext;

import java.util.List;

public class Division extends ExecutableCommand {

    public Division() {
        super("Division");
    }

    @Override
    public void execute(ExecutionContext context, List<String> inputArgs) {
        double a = context.getStack().pop();
        double b = context.getStack().pop();
        if (b == 0) {
            System.err.println("Division by zero!");
            return;
        }
        context.getStack().push(a / b);
    }
}
