package shashev.Commands;

import shashev.Executor.ExecutionContext;

import java.util.List;

public class Sqrt extends ExecutableCommand {

    public Sqrt() {
        super("Sqrt");
    }

    @Override
    public void execute(ExecutionContext context, List<String> inputArgs) {
        double a = context.getStack().pop();
        if (a < 0) {
            System.err.println("Extracting the root of a negative number: " + a);
            return;
        }
        context.getStack().push(Math.sqrt(a));
    }
}
