package prog;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LanguageCommand  implements Command {

    Map<String, LanguageChecker> langMap;

    public LanguageCommand() {
        langMap= new HashMap<String, LanguageChecker>();
        langMap.put("english", new EnglishChecker());
    }

    @Override
    public boolean execute(String[] args) throws BadUrlException, IOException {

        try {
            if (args.length < 2) {
                throw new BadUrlException();
            }

            Connection.Response res = Jsoup.connect(args[1])
                    .ignoreContentType(true).execute();
            String type = res.contentType();

            if (args.length < 3) {return false;}

            if (!type.startsWith("text/")) {return false;}

            Document doc = res.parse();
            String text = doc.body().text();

            LanguageChecker langChecker = langMap.get(args[2]);
            if (langChecker == null) {return false;}
            return langChecker.isMyLanguage(text);

        } catch (IllegalArgumentException e) {
            throw new BadUrlException();
        }
    }
}
