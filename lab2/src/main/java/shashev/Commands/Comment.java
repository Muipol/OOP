package shashev.Commands;

import shashev.Executor.ExecutionContext;

import java.util.List;

public class Comment extends ExecutableCommand {

    public Comment() {
        super("Comment");
    }

    @Override
    public void execute(ExecutionContext context, List<String> inputArgs) { }
}
