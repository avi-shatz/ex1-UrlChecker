package prog;


/**
 * This interface enables generic classes that provide an input to our program.
 */
public interface LineReader {

    /**
     * A generic method to read a line from user input
     * @return Array of strings with the command, URL and optional arguments.
     * @exception LineReaderException In case of failure in reading a line from user.
     */
    String[] getLine() throws LineReaderException;
}
