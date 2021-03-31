package prog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * This class checks if a certain text is in English.
 */
public class EnglishChecker implements LanguageChecker {

    /**
     * The maximum differance between an English text frequency table
     * and the English language frequency table.
     */
    private static final double THRESHOLD = 0.004;

    /**
     * This function gets a string and checks if it is written in English.
     * @param str The string to be checked.
     * @return True if str is in English false otherwise.
     */
    @Override
    public boolean isMyLanguage(String str) {

        Map<Character, Double> strFTable = getStrFrequencyTable(str);
        Map<Character, Double> englishFTable = getEnglishFrequencyTable();

        double tableVariance = 0.0;

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            double variance  = strFTable.get(alphabet) - englishFTable.get(alphabet);
            tableVariance += (Math.pow(variance, 2));
        }

        return tableVariance < THRESHOLD;
    }

    /**
     * This function provides a letters frequency table for any given text.
     * @param str The text that their letters will be counted.
     * @return A map representing the frequency table.
     */
    private Map<Character, Double> getStrFrequencyTable(String str) {
        str = str.toLowerCase(Locale.ENGLISH);

        Map<Character, Double> frequencyTable = new HashMap<>(26);
        int[] countArr = countLetters(str);
        int numOfLetters = Arrays.stream(countArr).sum();

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            double frequency = 0.0;
            if (numOfLetters != 0) {
                frequency = countArr[alphabet-'a'] / (double) numOfLetters;
            }
            frequencyTable.put(alphabet, frequency);
        }

        return frequencyTable;
    }

    /**
     * Counts the number of occurrences of each letter in a text into an array,
     * each sell represent different letter.
     * @param str A string with text, to count the letters in the string.
     * @return An array in a size of 26 that will store the count for each letter.
     */
    int[] countLetters(String str) {
        int[] countArr = new int['z'-'a'+1];
        Arrays.fill(countArr, 0);

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (!Character.isLetter(c)) {
                continue;
            }

            if (c >= 'a' && c <= 'z') {
                countArr[c - 'a']++;
            }
        }

        return countArr;
    }

    /**
     * This function provides the english letters frequency table.
     * @return A map representing the frequency table.
     */
    private Map<Character, Double> getEnglishFrequencyTable() {
        Map<Character, Double> fTable = new HashMap<>();
        fTable.put('a', 0.0748);
        fTable.put('b', 0.0134);
        fTable.put('c', 0.0411);
        fTable.put('d', 0.0308);
        fTable.put('e', 0.1282);
        fTable.put('f', 0.0240);
        fTable.put('g', 0.0185);
        fTable.put('h', 0.0414);
        fTable.put('i', 0.0725);
        fTable.put('j', 0.0014);
        fTable.put('k', 0.0053);
        fTable.put('l', 0.0403);
        fTable.put('m', 0.0340);
        fTable.put('n', 0.0673);
        fTable.put('o', 0.0785);
        fTable.put('p', 0.0314);
        fTable.put('q', 0.0010);
        fTable.put('r', 0.0609);
        fTable.put('s', 0.0614);
        fTable.put('t', 0.1002);
        fTable.put('u', 0.0316);
        fTable.put('v', 0.0108);
        fTable.put('w', 0.0131);
        fTable.put('x', 0.0044);
        fTable.put('y', 0.0127);
        fTable.put('z', 0.0011);
        return fTable;
    }
}
