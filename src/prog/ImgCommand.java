package prog;

import org.jsoup.Connection.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class ImgCommand implements Command {
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
            if (imgTag != null) {
                return true;
            }

            return false;
        } catch (IllegalArgumentException e) {
            throw new BadUrlException();
        }

    }
}
