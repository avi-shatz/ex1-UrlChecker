package prog;

import java.io.IOException;

/**
 * A generic interface representing a command that can be executed.
 */
public interface Command {
    /**
     * Execute the command and returns a boolean value.
     * @param args Array of strings with the command, url and additional arguments.
     * @return A boolean value depending on the execution results.
     * @throws BadUrlException In case the url is not valid.
     * @throws IOException In case of a problem with reading files.
     */
    boolean execute(String[] args) throws BadUrlException, IOException;
}
