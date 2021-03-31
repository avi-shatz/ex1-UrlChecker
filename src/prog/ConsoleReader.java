package prog;
import java.util.Scanner;

/**
 * Implements the LineReader Interface by reading input from the console.
 */
public class ConsoleReader implements LineReader{

    @Override
    public String[] getLine() throws LineReaderException {
        Scanner scanner;
        String[] inputLine;

        try {
            scanner = new Scanner(System.in);
            inputLine = scanner.nextLine().trim().split(" ");

        } catch (Exception e) {
            throw new LineReaderException(e.getMessage());
        }

        return inputLine;
    }


}
