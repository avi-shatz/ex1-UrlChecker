package prog;

public class App {

    public void run() {
        LineReader lineReader = new ConsoleReader();
        CommandContainer commandContainer = new CommandContainer();
        Command command = null;
        String inputLine[];

        while (true) {
            System.out.println("Please enter a command and its arguments in one line");
            try {
                inputLine = lineReader.getLine();
                command = commandContainer.get(inputLine[0]);
                boolean b = command.execute(inputLine);
                System.out.println(b);

            } catch (InvalidCommandException e) {
                System.out.println("invalid command");
            } catch (BadUrlException e) {
                System.out.println("bad url");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("error");
            }
        }
    }

}
