package test;

import prog.BadUrlException;
import prog.Command;
import prog.CommandContainer;
import prog.InvalidCommandException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test2 {
    private static String runCommand(String inputArgs) {
        CommandContainer commandContainer = new CommandContainer();
        Command command = null;
        String[] args = null;
        try {
            args = inputArgs.trim().split(" ");
            command = commandContainer.get(args[0]);
            boolean b = command.execute(args);
            return Boolean.toString(b);
        } catch (InvalidCommandException e) {
            return "invalid command";
        } catch (BadUrlException e) {
            return "bad url";
        } catch (Exception e) {
            return "error";
        }
    }

    public static void main(String[] args) {
        String t1 = "t https://cs.hac.ac.il t";
        String t2 = "t https://cs.hac.ac.il/wp-content/uploads/2020/07/hat.png img/gif";
        String t3 = "";
        String t4 = "t https://cs.hac.ac.il/wp-content/uploads/2020/07/hat.png img"; // img and not image should be false??
        String t5 = "t";  // should be bad url??
        String t6 = "t https://haha"; // should be an error??

        /*
        String t4 = "t https://cs.hac.ac.il/wp-content/uploads/2020/07/hat.png img"; // img and not image should be false??
        String t5 = "t";  // should be bad url??
        String t6 = "t https://haha"; // should be an error??
        */

        System.out.println("1: " + runCommand(t1));
        System.out.println("2: " + runCommand(t2));
        System.out.println("3: " + runCommand(t3));
        System.out.println("4: " + runCommand(t4));
        System.out.println("5: " + runCommand(t5));
        System.out.println("6: " + runCommand(t6));
    }
}
