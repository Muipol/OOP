package shashev.Commands;

import shashev.Executor.ExecutionContext;

import java.util.List;

public class Subtraction extends ExecutableCommand {

    public Subtraction() {
        super("Subtraction");
    }

    @Override
    public void execute(ExecutionContext context, List<String> inputArgs) {
        double a = context.getStack().pop();
        double b = context.getStack().pop();
        context.getStack().push(a - b);
    }
}
