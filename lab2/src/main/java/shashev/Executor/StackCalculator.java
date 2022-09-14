package shashev.Executor;


import shashev.Exceptions.BuildCommandException;
import shashev.Exceptions.CommandNotFoundException;
import shashev.Factory.CommandFactory;
import shashev.Validator.Validator;
import shashev.Commands.ExecutableCommand;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class StackCalculator {

    private BufferedReader reader = null;

    public StackCalculator(String inputStreamName) throws FileNotFoundException {
        if (inputStreamName == null) {
            reader = new BufferedReader(new InputStreamReader(System.in));
        } else {
            reader = new BufferedReader(new FileReader(inputStreamName));
        }
    }

    public void calculate() {
        String nextLine;
        ExecutionContext context = new ExecutionContext();
        List<String> inputArgs;
        try {
            while ((nextLine = reader.readLine()) != null) {
                String[] commandLine = nextLine.split("\\s+");
                ExecutableCommand nextCommand = CommandFactory.getInstance().buildCommand(commandLine[0]);
                inputArgs = Arrays.asList(commandLine).subList(1, commandLine.length);
                if (Validator.getInstance().validate(nextCommand, context, inputArgs)) {
                    nextCommand.execute(context, inputArgs);
                } else {
                    System.err.println(Validator.getInstance().getLastDecision());
                }
            }
        } catch (IOException | CommandNotFoundException | BuildCommandException e) {
            e.printStackTrace();
        }
    }
}
