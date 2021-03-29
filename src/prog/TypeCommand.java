package prog;

import org.jsoup.Jsoup;

import java.io.IOException;

public class TypeCommand implements Command {
    @Override
    public boolean execute(String[] args) throws BadUrlException, IOException {

        try {
            if (args.length < 2) {throw new BadUrlException();}

            String type = Jsoup.connect(args[1]).ignoreContentType(true).
                    execute().contentType();

            if (args.length < 3) {return false;}

            if (type.startsWith(args[2])) {
                return true;
            }
        } catch (IllegalArgumentException e) {
            throw new BadUrlException();
        }

        return false;
    }
}
