package Comperators;

import NounPhrasesPackage.AbstractNounPhrase;

import java.util.Comparator;

/**
 * a comparator class that comber noun phrases by their string phrase members.
 *
 * @author ori katzir
 * @version ass7
 * @since 2022/06/15
 */
public class AlphabetNounPhrasesComparator implements Comparator<AbstractNounPhrase> {

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
    public int compare(AbstractNounPhrase compared, AbstractNounPhrase toCompare) {
        return String.CASE_INSENSITIVE_ORDER.compare(compared.getPhrase(), toCompare.getPhrase());
    }
}
