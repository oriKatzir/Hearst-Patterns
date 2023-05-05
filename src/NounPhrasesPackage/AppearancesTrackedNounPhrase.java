package NounPhrasesPackage;

/**
 * gives an AbstractNounPhrase object the attributes of being able to keep track of the num of its appearances.
 * <p>this class is a mix of the decorator pattern and an extension for Hyponyms</p>
 * <p>this class used to decorated the Hypernym class in part 2 of this assignment</p>
 *
 * @author ori katzir
 * @version ass7
 * @see AbstractNounPhrase
 * @since 2022/06/15
 */
public class AppearancesTrackedNounPhrase extends AbstractNounPhrase {
    private AbstractNounPhrase nounPhrase;
    private int appearancesCounter;

    /**
     * a constructor.
     *
     * @param phrase a noun phrase
     */
    public AppearancesTrackedNounPhrase(String phrase) {
        super(phrase);
        appearancesCounter = 1;
    }

    /**
     * a constructor.
     *
     * @param nounPhrase a nounPhrase to be decorated with appearances tracking
     */
    public AppearancesTrackedNounPhrase(AbstractNounPhrase nounPhrase) {
        super(nounPhrase.getPhrase());
        this.nounPhrase = nounPhrase;
        appearancesCounter = 1;
    }


    /**
     * a getter for this AppearancesTrackedNounPhrase appearancesCounter member.
     *
     * @return this AppearancesTrackedNounPhrase appearancesCounter member
     */
    public int getAppearancesCounter() {
        return this.appearancesCounter;
    }

    /**
     * a method to increase the appearance counter of this AppearancesTrackedNounPhrase.
     */
    public void increaseAppearancesCounter() {
        this.appearancesCounter++;
    }

    /**
     * a method to increase the appearance counter of this AppearancesTrackedNounPhrase.
     *
     * @param numToIncreaseBy a number to increase by
     */
    public void increaseAppearancesCounter(int numToIncreaseBy) {
        this.appearancesCounter += numToIncreaseBy;
    }

    /**
     * a method that create and returns the string representing this AppearancesTrackedNounPhrase.
     *
     * @return string representing this AppearancesTrackedNounPhrase
     */
    @Override
    public String toString() {
        return this.nounPhrase.toString();
    }
}
