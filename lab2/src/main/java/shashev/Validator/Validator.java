package shashev.Validator;

import shashev.Commands.ExecutableCommand;
import shashev.Executor.ExecutionContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Validator {

    private static Validator instance = null;
    private String lastDecision;
    private static final Properties contextProperties = new Properties();
    private static final Properties inputArgumentsProperties = new Properties();

    private Validator() {
        try {
            contextProperties.load(
                    new FileInputStream("./src/main/resources/context.properties"));
            inputArgumentsProperties.load(
                    new FileInputStream("./src/main/resources/inputArguments.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    public boolean validate(ExecutableCommand command, ExecutionContext context, List<String> inputArgs) {
        if (context.getStack().size() < Integer.parseInt(contextProperties.getProperty(command.getCommandName()))) {
            lastDecision = command.getCommandName() + ": Not enough arguments in stack to do this command!";
            return false;
        } else if (inputArgs.size() != Integer.parseInt(
                inputArgumentsProperties.getProperty(command.getCommandName()))) {
            lastDecision = command.getCommandName() + ": Illegal count of input arguments!";
            return false;
        }
        return true;
    }

    public String getLastDecision() {
        return lastDecision;
    }
}
