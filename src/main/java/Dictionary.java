import java.util.*;

public class Dictionary implements IsDictionary {

    private Map<String, Integer> dictionary = new HashMap();

    /**
     * Store word in dictionary
     * @param word word to store in dictionary
     */
    public void store(String word) throws IllegalArgumentException {
        if (word == null) {
            throw new IllegalArgumentException("Param cannot be null");
        }

        dictionary.compute(word.toLowerCase(), (k, v) -> v == null ? 1 : v + 1);
    }

    /**
     * Get word occurrence in dictionary
     * @param word word to find in dictionary
     * @return how many time word occurred in dictionary
     */
    public int getOccurrence(String word) {
        if (word == null || !dictionary.containsKey(word.toLowerCase())) {
            return 0;
        }

        return dictionary.get(word.toLowerCase());
    }
}
