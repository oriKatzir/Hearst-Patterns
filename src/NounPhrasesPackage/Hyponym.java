package NounPhrasesPackage;

/**
 * a noun phrase than is a subtype of a NounPhrasesPackage.Hypernym.
 *
 * @author ori katzir
 * @version ass7
 * @see AppearancesTrackedNounPhrase
 * @since 2022/06/15
 */
public class Hyponym extends AppearancesTrackedNounPhrase {

    /**
     * a constructor method.
     *
     * @param phrase the phrase this NounPhrasesPackage.Hypernym represents
     */
    public Hyponym(String phrase) {
        super(phrase);
    }

    /**
     * a method that create and returns the string representing this noun phrase.
     *
     * @return string representing this noun phrase
     */
    @Override
    public String toString() {
        return this.getPhrase()
                + " (" + Integer.toString(super.getAppearancesCounter()) + ")";
    }
}
