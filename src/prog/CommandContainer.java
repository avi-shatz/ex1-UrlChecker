package prog;

import java.util.HashMap;
import java.util.Map;

/**
 * Container that stores commands with their names as keys.
 */
public class CommandContainer {

    /**
     * This map stores the available commands names as keys,
     * and their corresponding commands as values
     */
    private final Map<String, Command> hm;

    /**
     * Instantiate a HashMap with all the available commands.
     */
    public CommandContainer() {
        hm = new HashMap<>();
        hm.put("q", new ExitCommand());
        hm.put("t", new TypeCommand());
        hm.put("w", new WordSearchCommand());
        hm.put("i", new ImgCommand());
        hm.put("l", new LanguageCommand());
    }

    /**
     * Get a command by the command name.
     * @param commandName The name of the registered command.
     * @return The command with the provided name.
     * @throws InvalidCommandException in case the commands name is not registered.
     */
    public Command get(String commandName) throws InvalidCommandException {
        Command command = hm.get(commandName);
        if (command == null) {
            throw new InvalidCommandException();
        }
        return command;
    }
}
