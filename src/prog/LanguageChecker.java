package prog;

/**
 *  Classes that implements LanguageChecker check text with a specific language .
 */
public interface LanguageChecker {

    /**
     * This function gets a string and checks if it is written in A specific language.
     * @param str The string to be checked.
     * @return True if str is in The class language false otherwise.
     */
    boolean isMyLanguage(String str);
}
