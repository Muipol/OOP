import shashev.Executor.StackCalculator;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            StackCalculator stackCalculator = new StackCalculator(args.length == 0 ? null : args[0]);
            stackCalculator.calculate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
