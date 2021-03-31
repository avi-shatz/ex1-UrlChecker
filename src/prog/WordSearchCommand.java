package prog;

import java.io.IOException;
import java.util.Set;

/**
 * Checking if all the words in a file present in the url content.
 */
public class WordSearchCommand  implements Command {

    /**
     * This command Checks if all the words in a file present in the url content.
     * @param args Array of strings with the command, url and the file path.
     * @return True if the content contains all the words from the file, False otherwise.
     * @throws BadUrlException In case the url is not valid.
     * @throws IOException In case of a problem with reading files.
     */
    @Override
    public boolean execute(String[] args) throws BadUrlException, IOException {

        try {
            String text = StringUtil.getUrlText(args);
            if (text == null) {return false;}
            if (args.length < 3) {return false;}

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
