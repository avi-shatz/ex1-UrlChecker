package prog;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This command Checks if a given url content is in a specific language.
 */
public class LanguageCommand  implements Command {

    /**
     * This map stores the available languages as keys,
     * and their corresponding checkers as values
     */
    private final Map<String, LanguageChecker> langMap;

    /**
     * Initialize map with all the available language checkers.
     */
    public LanguageCommand() {
        langMap= new HashMap<>();
        langMap.put("english", new EnglishChecker());
    }

    /**
     * Checks if the content from the given url is written in the given language.
     * @param args Array of strings with the command, url and the language name.
     * @return True if the content is in the given language, False otherwise.
     * @throws BadUrlException In case the url is not valid.
     * @throws IOException In case of a problem with reading files.
     */
    @Override
    public boolean execute(String[] args) throws BadUrlException, IOException {

        try {
            String text = StringUtil.getUrlText(args);
            if (text == null) {return false;}
            if (args.length < 3) {return false;}

            LanguageChecker langChecker = langMap.get(args[2]);
            if (langChecker == null) {return false;}
            return langChecker.isMyLanguage(text);

        } catch (IllegalArgumentException e) {
            throw new BadUrlException();
        }
    }


}
