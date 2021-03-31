package prog;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A static class, provides functions to work with strings and urls.
 */
public final class StringUtil {

    /**
     * private constructor to prevent instantiation of this static class.
     */
    private StringUtil() {
    }

    /**
     * Inserting each word from a text string into an HashSet.
     * @param text a string with text.
     * @return A HashSet that contains all the words extracted from text.
     */
    public static Set<String> getWordsInHash(String text) {
        String[] words = text.trim().split("\\s+");
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));

        return wordsSet;
    }

    /**
     * read a file in the provided file path and convert it to a string.
     * @param filePath the file path of the file to convert.
     * @return the converted string
     * @throws IOException in case we had a problem reading the given file
     */
    public static String getFileAsString (String filePath) throws IOException {
        StringBuilder str = new StringBuilder();

        File f1 = new File(filePath);
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String line;

        while((line = br.readLine())!=null)   //Reading Content from the file
        {
            str.append(line); // appending each line to the final string
        }

        fr.close();

        return str.toString();
    }

    /**
     * Gets the text content from a given url.
     * @param args Array of strings with the command, and url.
     * @return True if the content contains all the words from the file, False otherwise.
     * @throws BadUrlException In case the url is not valid.
     * @throws IOException In case of a problem with reading files.
     */
    public static String getUrlText(String[] args) throws BadUrlException, IOException {

        if (args.length < 2) {throw new BadUrlException();}

        Connection.Response res = Jsoup.connect(args[1])
                .ignoreContentType(true).execute();
        String type = res.contentType();

        if (!type.startsWith("text/")) {return null;}

        Document doc = res.parse();
        return doc.body().text();
    }

}
