package IO;

import DataBase.RelationsDataBase;
import NounPhrasesPackage.Hypernym;
import NounPhrasesPackage.Hyponym;
import NounPhrasesPackage.HyponymsCollection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * a class that finds noun relations in a String with the help of regex.
 * <p>all found relations are inserted into the relations data base</p>
 *
 * @author ori katzir
 * @version ass7
 * @since 2022/06/15
 */
public class NounRelationFinder {

    private final RelationsDataBase dataBase = RelationsDataBase.getDataBaseInstance();
    private static final String FIRST_PATTERN_REGEX =
            "<np>([^<]+)</np>(?: ,)? (?:such as|including|especially) (?:, )?<np>([^<]+)</np> "
                    + "(?:, <np>([^>]+)</np> )*(?:(?:or|and) <np>([^<]+)</np>)?";
    private static final String SECOND_PATTERN_REGEX =
            "(?:such )<np>([^<]+)</np> as <np>([^<]+)</np> "
                    + "(?: ?(?:,)? ?(and|or)? <np>[^<]+</np>)*";
    private static final String THIRD_PATTERN_REGEX =
            "<np>([^<]+)</np> (?:, )?(?:which is )(?:an example of |a kind of |a class of )?<np>([^<]+)</np>";
    private static final String FIRST_PATTERN_FIRST_OPTION = "such as";
    private static final String FIRST_PATTERN_SECOND_OPTION = "including";
    private static final String FIRST_PATTERN_THIRD_OPTION = "especially";
    private static final String SECOND_PATTERN_FIRST_OPTION = "such";
    private static final String THIRD_PATTERN_FIRST_OPTION = "which is";
    private static final int FIRST_HYPONYM_GROUP_INDEX = 2;
    private static final int HYPERNYM_GROUP_INDEX = 1;
    private static final int MINIMUM_HYPONYMS_NUMBER = 1;


    /**
     * this method split the given String by '.' and send in to a method to search for hearts relations.
     *
     * @param paragraph a string to search hearts relations in
     */
    public void detect(String paragraph) {
        String[] lines = paragraph.split("\\.");
        for (String line : lines) {
            findASuitablePattern(line);
        }
    }

    /**
     * this method search in a given String a match for a first or second patterns.
     *
     * @param pattern a pattern compiled with a first or second regex pattern
     * @param line    a Sting to search matches in
     */
    private void searchForFirstOrSecondPatternMatches(Pattern pattern, String line) {
        HyponymsCollection hyponyms = new HyponymsCollection();
        Matcher matcher = pattern.matcher(line);
        Hypernym hypernym = null;
        while (matcher.find()) {
            hypernym = new Hypernym(matcher.group(HYPERNYM_GROUP_INDEX));
            for (int i = FIRST_HYPONYM_GROUP_INDEX; i <= matcher.groupCount(); i++) {
                if (matcher.group(i) == null) {
                    break;
                }
                hyponyms.addHyponym(new Hyponym(matcher.group(i)));
            }
            if (hyponyms.getSize() >= MINIMUM_HYPONYMS_NUMBER) {
                dataBase.addRelation(hypernym, hyponyms);
            }
        }
    }

    /**
     * this method search in a given String a match for the third regex patterns.
     *
     * @param pattern a pattern compiled with the third regex pattern
     * @param line    a Sting to search matches in
     */
    private void searchForRelationThirdPatternMatches(Pattern pattern, String line) {
        Hypernym hypernym;
        HyponymsCollection hyponyms = new HyponymsCollection();
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            hypernym = new Hypernym(matcher.group(FIRST_HYPONYM_GROUP_INDEX));
            hyponyms.addHyponym(new Hyponym(matcher.group(HYPERNYM_GROUP_INDEX)));
            dataBase.addRelation(hypernym, hyponyms);
        }
    }

    /**
     * this method find which pattern is sutible for finding matches in the given string.
     *
     * @param line a given line to search hearst relations in
     */
    private void findASuitablePattern(String line) {
        line = line.toLowerCase();
        Pattern pattern;
        if (line.contains(FIRST_PATTERN_FIRST_OPTION)
                || line.contains(FIRST_PATTERN_SECOND_OPTION)
                || line.contains(FIRST_PATTERN_THIRD_OPTION)) {
            searchForFirstOrSecondPatternMatches(Pattern.compile(FIRST_PATTERN_REGEX), line);
        } else if (line.contains(SECOND_PATTERN_FIRST_OPTION)) {
            searchForFirstOrSecondPatternMatches(Pattern.compile(SECOND_PATTERN_REGEX), line);
        } else if (line.contains(THIRD_PATTERN_FIRST_OPTION)) {
            searchForRelationThirdPatternMatches(Pattern.compile(THIRD_PATTERN_REGEX), line);
        }
    }
}