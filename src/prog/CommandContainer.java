package prog;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private Map<String, Command> hm;

    public CommandContainer() {
        hm = new HashMap<String, Command>();
        hm.put("q", new ExitCommand());
    }

    Command get(String commandName) throws InvalidCommandException {
        Command command = hm.get(commandName);
        if (command == null) {
            throw new InvalidCommandException();
        }
        return command;
    }
}
