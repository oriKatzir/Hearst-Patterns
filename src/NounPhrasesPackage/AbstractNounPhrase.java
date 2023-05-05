package NounPhrasesPackage;


/**
 * an abstract class representing a noun phrase.
 * <p>this method is meant to reuse sheared code</p>
 *
 * @author ori katzir
 * @version ass7
 * @since 2022/06/15
 */
public abstract class AbstractNounPhrase {
    private final String phrase;

    /**
     * a constructor method.
     *
     * @param phrase a string representing a noun phrase
     */
    public AbstractNounPhrase(String phrase) {
        this.phrase = phrase;
    }

    /**
     * a getter for the phrase member.
     *
     * @return the phrase member of this noun phrase.
     */
    public String getPhrase() {
        return phrase;
    }

    /**
     * a method that create and returns the string representing this noun phrase.
     *
     * @return string representing this noun phrase
     */
    public abstract String toString();
}
