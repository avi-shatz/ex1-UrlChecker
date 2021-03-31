package prog;

import org.jsoup.Jsoup;
import java.io.IOException;

/**
 * Checking url content type.
 */
public class TypeCommand implements Command {

    /**
     * This command Checks if url content type matches the requested content type.
     * @param args Array of strings with the command, url and the content type.
     * @return True if the content types matches, False otherwise.
     * @throws BadUrlException In case the url is not valid.
     * @throws IOException In case of a problem with reading files.
     */
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
