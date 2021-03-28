package prog;


/**
 * interface that provides an input to our program.
 */
public interface LineReader {

    /**
     * a generic method to read a line from user input
     * @return String[] with the command, URL and optional arguments.
     * @exception LineReaderException in case of failure in reading a line from user.
     */
    public String[] getLine() throws LineReaderException;
}
