package test;

import prog.BadUrlException;
import prog.Command;
import prog.CommandContainer;
import prog.InvalidCommandException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

        ArrayList<String> inputList = new ArrayList<String>();
        inputList.add("l https://es.wikipedia.org sp");
        inputList.add("l https://es.wikipedia.org english");
        inputList.add("l https://es.wikipedia.org/wiki/COVID-19 english");
        inputList.add("l https://www.gutenberg.org/files/64317/64317-0.txt english");
        inputList.add("l https://en.wikipedia.org/wiki/Wikipedia:About english");
        inputList.add("l http://abu.cnam.fr/cgi-bin/donner_html?methode3 english");
        inputList.add("l http://abu.cnam.fr/cgi-bin/donner_html?nddp1 english");

        /*
        inputList.add("w https://en.wikipedia.org/wiki/Help:Introduction resources/words.txt");
        inputList.add("t https://cs.hac.ac.il/wp-content/uploads/2020/07/hat.png img"); // img and not image should be false??
        inputList.add("t");  // should be bad url??
        inputList.add("t https://haha"); // should be an error??
        */

        for (int i = 0; i < inputList.size(); i++) {
            System.out.println(i + ": " + runCommand(inputList.get(i)));
        }


    }
}
