package prog;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordSearchCommand  implements Command {

    @Override
    public boolean execute(String[] args) throws BadUrlException, IOException {

        try {
            if (args.length < 2) {throw new BadUrlException();}

            Connection.Response res = Jsoup.connect(args[1])
                    .ignoreContentType(true).execute();
            String type = res.contentType();

            if (args.length < 3) {return false;}

            if (!type.startsWith("text/")) {return false;}

            Document doc = res.parse();
            String text = doc.body().text();
            String wordsToSearchStr = StringUtil.getFileAsString(args[2]);

            if (wordsToSearchStr.trim().length() == 0) {return true;}

            Set<String> wordsToSearch = StringUtil.getWordsInHash(wordsToSearchStr);
            Set<String> wordsFromUrl = StringUtil.getWordsInHash(text);

            if (wordsFromUrl.containsAll(wordsToSearch)) {
                return true;
            }
        } catch (IllegalArgumentException e) {
            throw new BadUrlException();
        }

        return false;
    }
}
