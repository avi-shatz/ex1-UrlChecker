package prog;

import org.jsoup.Connection.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * This command Checks if a url content contains an img tag.
 */
public class ImgCommand implements Command {

    /**
     * Checks if the given url content contains an img tag
     * @param args Array of strings with the command and the url.
     * @return True if the content contains an img tag, False otherwise.
     * @throws BadUrlException In case the url is not valid.
     * @throws IOException In case of a problem with reading files.
     */
    @Override
    public boolean execute(String[] args) throws BadUrlException, IOException {

        try {
            if (args.length < 2) {throw new BadUrlException();}

            Response res = Jsoup.connect(args[1])
                    .ignoreContentType(true).execute();
            String type = res.contentType();

            if (!type.startsWith("text/")) {
                return false;
            }

            Document doc = res.parse();
            Element imgTag = doc.select("img").first();
            return imgTag != null;

        } catch (IllegalArgumentException e) {
            throw new BadUrlException();
        }

    }
}
