package prog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public final class StringUtil {


    private StringUtil() {
    }

    public static Set<String> getWordsInHash(String text) {
        Set<String> wordsSet = new HashSet<String>();
        String[] words = text.trim().split("\\s+");
        for (String word: words) {
            wordsSet.add(word);
        }
        return wordsSet;
    }

    public static String getFileAsString (String fileName) throws IOException {
        String str = "";

        File f1 = new File(fileName);
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String line;

        while((line = br.readLine())!=null)   //Reading Content from the file
        {
            str += line;
        }

        fr.close();

        return str;
    }

}
