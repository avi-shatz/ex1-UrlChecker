package prog;

public class ExitCommand implements Command{
    @Override
    public boolean execute(String[] args) {
        System.exit(0) ;
        return false;
    }
}
