import NounPhrasesPackage.AppearancesTrackedNounPhrase;
import Comperators.AppearancesTrackedNounPhrasesComparator;
import DataBase.RelationsDataBase;
import NounPhrasesPackage.Hypernym;
import NounPhrasesPackage.Hyponym;
import NounPhrasesPackage.HyponymsCollection;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * a class to search across the relation database all the matching hypernyms to a given lemma.
 *
 * @author ori katzir
 * @version ass7
 * @see Hyponym
 * @since 2022/06/15
 */


public class DiscoverHypernym {
    private RelationsDataBase dataBase = RelationsDataBase.getDataBaseInstance();

    /**
     * a method that creates a list of appearances Tracked Hypernyms related to a given lemma.
     * <p>if there are no related Hypernyms than a massage will be printed</p>
     * <p>if there are related hypernyms then a call for printHypernyms will be made</p>
     *
     * @param lemma a noun phrase to search related hypernyms for
     * @see DiscoverHypernym#printHypernyms(java.util.List)
     * @see AppearancesTrackedNounPhrase
     */
    private static void findFittingHypernyms(String lemma) {
        RelationsDataBase dataBase = RelationsDataBase.getDataBaseInstance();
        String str = "";
        List<AppearancesTrackedNounPhrase> appearancesTrackedHypernymList = new LinkedList<>();

        for (Map<Hypernym, HyponymsCollection> map : dataBase.getListOfMaps()) {
            for (Map.Entry<Hypernym, HyponymsCollection> entry : map.entrySet()) {
                Hyponym searchedHyponym = entry.getValue().getHyponymIfIsInCollection(lemma);
                if (searchedHyponym != null) {
                    AppearancesTrackedNounPhrase trackedHypernym = new AppearancesTrackedNounPhrase(entry.getKey());
                    trackedHypernym.increaseAppearancesCounter(searchedHyponym.getAppearancesCounter());
                    appearancesTrackedHypernymList.add(trackedHypernym);
                }
            }
        }
        if (appearancesTrackedHypernymList.isEmpty()) {
            System.out.println("The lemma doesn't appear in the corpus.");
        } else {
            appearancesTrackedHypernymList.sort(new AppearancesTrackedNounPhrasesComparator());
            printHypernyms(appearancesTrackedHypernymList);
        }
    }

    /**
     * a method that prints out all the AppearancesTrackedNounPhrase in a given list.
     *
     * @param appearancesTrackedHypernymList a list of appearance tracked hypernyms
     */
    private static void printHypernyms(List<AppearancesTrackedNounPhrase> appearancesTrackedHypernymList) {
        String str = "";
        for (AppearancesTrackedNounPhrase hypernym : appearancesTrackedHypernymList) {
            str += hypernym.toString() + "(" + Integer.toString(hypernym.getAppearancesCounter()) + ")\n";
        }
        System.out.println(str);
    }

    /**
     * a main method.
     *
     * @param args the fist args element is a path for the corpus and the second is a lemma to search in the database.
     */
    public static void main(String[] args) {
        CreateHypernymDatabase.creat(args[0]);
        String lemma = args[1];
        if (args.length > 2) {
            for (int i = 2; i < args.length; i++) {

                lemma = lemma + " " + args[i];
            }
        }
        findFittingHypernyms(lemma);
    }
}
