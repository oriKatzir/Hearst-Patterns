package DataBase;

import Comperators.AlphabetNounPhrasesComparator;
import NounPhrasesPackage.Hypernym;
import NounPhrasesPackage.Hyponym;
import NounPhrasesPackage.HyponymsCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

/**
 * a database holding NounPhrasesPackage.Hypernym relations with an array od 26 treeMaps.
 * <p>every map represent a letter in the ABC, every tree hold hypernyms starting with suitable index of the array</p>
 * <p>this class implements the Singleton design pattern</p>
 *
 * @author ori katzir
 * @version ass7
 * @since 2022/06/15
 */
public class RelationsDataBase {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 3;
    public static final int D = 4;
    public static final int E = 5;
    public static final int F = 6;
    public static final int G = 7;
    public static final int H = 8;
    public static final int I = 9;
    public static final int J = 10;
    public static final int K = 11;
    public static final int L = 12;
    public static final int M = 13;
    public static final int N = 14;
    public static final int O = 15;
    public static final int P = 16;
    public static final int Q = 17;
    public static final int R = 18;
    public static final int S = 19;
    public static final int T = 20;
    public static final int U = 21;
    public static final int V = 22;
    public static final int W = 23;
    public static final int X = 24;
    public static final int Y = 25;
    public static final int Z = 26;
    public static final int NONE_LETTER = 0;
    public static final int MINIMUM_HYPONYM_REQUIRED_FOR_PRINTING = 3;
    private static RelationsDataBase instance;
    private final List<Map<Hypernym, HyponymsCollection>> listOfMaps;

    /**
     * a privet constructor for implementing the singleton design pattern.
     */
    private RelationsDataBase() {
        this.listOfMaps = new ArrayList<>();
        initMapArray();
    }

    /**
     * initializing the treeMap array member, a map for every english letter.
     */
    private void initMapArray() {
        for (int letter = NONE_LETTER; letter <= Z; letter++) {
            Map<Hypernym, HyponymsCollection> map = new TreeMap<>(new AlphabetNounPhrasesComparator());
            this.listOfMaps.add(map);
        }
    }

    /**
     * a getter for the only instance of this class.
     * <p>if the instance is not initialise then a call for the constructor is made</p>
     *
     * @return the only instance of this class
     */
    public static RelationsDataBase getDataBaseInstance() {
        if (instance == null) {
            instance = new RelationsDataBase();
        }
        return instance;
    }

    /**
     * a getter for the List of maps of this database.
     *
     * @return the List of maps of this database
     */
    public List<Map<Hypernym, HyponymsCollection>> getListOfMaps() {
        return this.listOfMaps;
    }

    /**
     * a method that's add a hearst pattern relation.
     * <p>if the Hypernym already exist in the database then the hyponyms will be added to it's HyponyoCollection</p>
     *
     * @param newHypernym          a Hypernym to add to the database
     * @param newHyponymCollection a collection that related to the new hypernym
     */
    public void addRelation(Hypernym newHypernym, HyponymsCollection newHyponymCollection) {
        String firstLetterOfTheNewHypernym =
                Character.toString(newHypernym.getPhrase().charAt(0)).toUpperCase();
        int index = getIndexForSutableMap(firstLetterOfTheNewHypernym);
        Map<Hypernym, HyponymsCollection> suitableMap = this.listOfMaps.get(index);
        if (suitableMap.containsKey(newHypernym)) {
            HyponymsCollection hyponymsCollection = suitableMap.get(newHypernym);
            Iterator<Hyponym> iterator = newHyponymCollection.getIterator();
            while (iterator.hasNext()) {
                hyponymsCollection.addHyponym(iterator.next());
            }
        } else {
            suitableMap.put(newHypernym, newHyponymCollection);
        }
    }

    /**
     * finds a suitable treeMap for a Hypernym according to its first character.
     *
     * @param firstLetterOfTheNewHypernym the first character of the hypernym
     * @return the suitable index of the suitable map int the map array
     */
    private int getIndexForSutableMap(String firstLetterOfTheNewHypernym) {
        int index;
        switch (firstLetterOfTheNewHypernym) {
            case "A":
                index = A;
                break;
            case "B":
                index = B;
                break;
            case "C":
                index = C;
                break;
            case "D":
                index = D;
                break;
            case "E":
                index = E;
                break;
            case "F":
                index = F;
                break;
            case "G":
                index = G;
                break;
            case "H":
                index = H;
                break;
            case "I":
                index = I;
                break;
            case "J":
                index = J;
                break;
            case "K":
                index = K;
                break;
            case "L":
                index = L;
                break;
            case "M":
                index = M;
                break;
            case "N":
                index = N;
                break;
            case "O":
                index = O;
                break;
            case "P":
                index = P;
                break;
            case "Q":
                index = Q;
                break;
            case "R":
                index = R;
                break;
            case "S":
                index = S;
                break;
            case "T":
                index = T;
                break;
            case "U":
                index = U;
                break;
            case "V":
                index = V;
                break;
            case "W":
                index = W;
                break;
            case "X":
                index = X;
                break;
            case "Y":
                index = Y;
                break;
            case "Z":
                index = Z;
                break;
            default:
                index = NONE_LETTER;
                break;
        }
        return index;
    }

    /**
     * a method to sort all the hyponyms for every Hypernym in every map in the map list.
     */
    public void sortHyponyoCollections() {
        if (this.listOfMaps == null) {
            return;
        }
        for (Map<Hypernym, HyponymsCollection> map : this.listOfMaps) {
            for (HyponymsCollection hyponyms : map.values()) {
                if (hyponyms.getSize() >= MINIMUM_HYPONYM_REQUIRED_FOR_PRINTING) {
                    hyponyms.sort();
                }
            }
        }
    }
}
