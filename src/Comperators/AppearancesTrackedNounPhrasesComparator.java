package Comperators;

import NounPhrasesPackage.AppearancesTrackedNounPhrase;

import java.util.Comparator;

/**
 * a comparator class that compare noun phrases that their appearances are being tracked by their appearances.
 * <p>this class uses composition to compare the noun phrases alphabetically if the appearances are equal</p>
 *
 * @author ori katzir
 * @version ass7
 * @since 2022/06/15
 */
public class AppearancesTrackedNounPhrasesComparator implements Comparator<AppearancesTrackedNounPhrase> {
    private final AlphabetNounPhrasesComparator alphabetNounPhrasesComparator =
            new AlphabetNounPhrasesComparator();

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     *
     * @param compared  the first object to be compared.
     * @param toCompare the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     */
    @Override
    public int compare(AppearancesTrackedNounPhrase compared, AppearancesTrackedNounPhrase toCompare) {
        int comparison =
                (-1) * Integer.compare(compared.getAppearancesCounter(),
                        toCompare.getAppearancesCounter());
        if (comparison == 0) {
            return alphabetNounPhrasesComparator.compare(compared, toCompare);
        }
        return comparison;
    }
}
