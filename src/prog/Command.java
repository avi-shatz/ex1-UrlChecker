package prog;

import java.io.IOException;

public interface Command {
    public boolean execute(String args[]) throws BadUrlException, IOException;
}
