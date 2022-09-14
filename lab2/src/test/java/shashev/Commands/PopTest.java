package shashev.Commands;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shashev.Executor.ExecutionContext;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {

    @Test
    @DisplayName("Pop operation test")
    void execute() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(1.);
        ExecutableCommand addition = new Pop();
        addition.execute(context, null);

        assertEquals(context.getStack().size(), 0);

        context.getStack().push(1.2);
        context.getStack().push(2.2);
        addition.execute(context, null);
        assertEquals(context.getStack().peek(), 1.2, 0.0);
    }
}