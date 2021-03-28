package prog;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        CommandContainer commandContainer = new CommandContainer();
        Command command = null;
        String inputLine[];

        while (true) {
            System.out.println("Please enter a command and its arguments in one line");
            try {
                inputLine = consoleReader.getLine();
                command = commandContainer.get(inputLine[0]);
                command.execute(inputLine);
            }
            catch (InvalidCommandException e) {
                System.out.println("invalid command");
            }
            catch (Exception e) {
                /*System.out.println(e.getMessage());*/
                System.out.println("error");
            }
        }
    }
}
