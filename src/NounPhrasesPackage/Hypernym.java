package NounPhrasesPackage;

/**
 * a noun phrase that represent a kind of noun phrases (hyponyms).
 *
 * @author ori katzir
 * @version ass7
 * @see AbstractNounPhrase
 * @since 2022/06/15
 */
public class Hypernym extends AbstractNounPhrase {

    /**
     * a constructor method.
     *
     * @param phrase a phrase for this NounPhrasesPackage.Hypernym to represent
     */
    public Hypernym(String phrase) {
        super(phrase);
    }

    /**
     * a method that create and returns the string representing this noun phrase.
     *
     * @return string representing this noun phrase
     */
    @Override
    public String toString() {

        return (this.getPhrase() + ": ");
    }
}
