package shashev.Commands;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shashev.Executor.ExecutionContext;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @Test
    @DisplayName("Division operation test")
    void execute() {
        ExecutionContext context = new ExecutionContext();
        context.getStack().push(-2.);
        context.getStack().push(3.);
        ExecutableCommand addition = new Division();
        addition.execute(context, null);
        assertEquals(-1.5, context.getStack().peek(), 0.0);
    }
}