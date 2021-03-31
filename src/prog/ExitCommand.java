package prog;

/**
 * Exits the program.
 */
public class ExitCommand implements Command{
    /**
     * Exits the program with status 0.
     * @param args Array of strings (could be empty).
     * @return The program will never reach the return value since the function stop the program.
     */
    @Override
    public boolean execute(String[] args) {
        System.exit(0) ;
        return false;
    }
}
