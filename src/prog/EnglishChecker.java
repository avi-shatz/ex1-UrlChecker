package prog;

import java.util.*;

public class EnglishChecker implements LanguageChecker {

    @Override
    public boolean isMyLanguage(String str) {

        Map<Character, Double> strFTable = getStrFrequencyTable(str);
        Map<Character, Double> englishFTable = getEnglishFrequencyTable();
        Double tableVariance = 0.0;
        Double threshold = 0.004;
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            Double variance  = strFTable.get(alphabet) - englishFTable.get(alphabet);
            tableVariance += (Math.pow(variance, 2));
        }
        if (tableVariance < threshold) {return true;}

        return false;
    }

    private Map<Character, Double> getStrFrequencyTable(String str) {
        str = str.toLowerCase(Locale.ENGLISH);

        int len = str.length();
        Map<Character, Integer> countChars = new HashMap<Character, Integer>(26);
        Map<Character, Double> frequencyTable = new HashMap<Character, Double>(26);
        int numOfChars = 0;

        for (int i = 0; i < len; ++i) {
            char c = str.charAt(i);
            if (!Character.isLetter(c)) {
                continue;
            }

            numOfChars++;

            if (!countChars.containsKey(c)) {
                countChars.put(c, 1);
            } else {
                countChars.put(c, countChars.get(c) + 1);
            }
        }

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            Double frequency = 0.0;

            if (countChars.containsKey(alphabet)) {
                frequency = countChars.get(alphabet) / Double.valueOf(numOfChars) ;
            }

            frequencyTable.put(alphabet, frequency);
        }

        return frequencyTable;
    }

    private Map<Character, Double> getEnglishFrequencyTable() {
        Map<Character, Double> fTable = new HashMap<Character, Double>();
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
