package NounPhrasesPackage;

import Comperators.AppearancesTrackedNounPhrasesComparator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * a class that uses a list data structure to hold a collection of hyponyms.
 *
 * @author ori katzir
 * @version ass7
 * @see Hyponym
 * @since 2022/06/15
 */
public class HyponymsCollection {

    private List<Hyponym> hyponymList;

    /**
     * a constructor method.
     */
    public HyponymsCollection() {
        this.hyponymList = new LinkedList<>();
    }

    /**
     * a getter for this NounPhrasesPackage.Hyponym collection size.
     *
     * @return this NounPhrasesPackage.Hyponym collection size
     */
    public int getSize() {
        return this.hyponymList.size();
    }

    /**
     * a getter for an iterator of this hyponymCollection hyponymList member.
     *
     * @return an iterator of this hyponymCollection hyponymList member
     */
    public Iterator<Hyponym> getIterator() {
        return this.hyponymList.iterator();
    }

    /**
     * getter for a NounPhrasesPackage.Hyponym in this collection, picked by index.
     *
     * @param index the index of NounPhrasesPackage.Hyponym
     * @return a NounPhrasesPackage.Hyponym in the index in this collection.
     */
    public Hyponym get(int index) {
        return this.hyponymList.get(index);
    }

    /**
     * adds a given NounPhrasesPackage.Hyponym to this NounPhrasesPackage.Hypernym list of NounPhrasesPackage.Hyponym.
     * <p>if the given NounPhrasesPackage.Hyponym is already in the list then it's appearance counter is increased</p>
     *
     * @param newHyponym a new hyponim to add to this NounPhrasesPackage.Hypernym list of NounPhrasesPackage.Hyponym
     */
    public void addHyponym(Hyponym newHyponym) {
        boolean isInList = false;
        if (!this.hyponymList.isEmpty()) {
            for (Hyponym hyponym : this.hyponymList) {
                if (hyponym.getPhrase().equals(newHyponym.getPhrase())) {
                    hyponym.increaseAppearancesCounter();
                    isInList = true;
                    break;
                }
            }
        }
        if (!isInList) {
            this.hyponymList.add(newHyponym);
        }
    }

    /**
     * search a NounPhrasesPackage.Hyponym by given String in this hyponym List member.
     *
     * @param phrase a lemma to search in this hyponyo collection
     * @return the NounPhrasesPackage.Hyponym fitting to the given lemma if found, null if not found
     */
    public Hyponym getHyponymIfIsInCollection(String phrase) {
        for (Hyponym hyponym : this.hyponymList) {
            if (hyponym.getPhrase().equals(phrase)) {
                return hyponym;
            }
        }
        return null;
    }

    /**
     * this method sorts the hyponym list with a AppearancesTrackedNounPhrasesComparator comparator.
     *
     * @see AppearancesTrackedNounPhrasesComparator
     */
    public void sort() {
        this.hyponymList.sort(new AppearancesTrackedNounPhrasesComparator());
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        String str = "";
        int size = this.getSize();
        for (int i = 0; i < size; i++) {
            str = str + this.hyponymList.get(i).toString() + ", ";
        }
        int lengthOfStr = str.length();
        str = str.substring(0, lengthOfStr - 2);
        str = str + "\n";
        return str;
    }
}
