package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * this class used for handling text in a given text file.
 * <p>every file is given by the corpus handling class</p>
 *
 * @author ori katzir
 * @version ass7
 * @see CorpusHandler
 * @since 2022/06/15
 */
public class TextHandler {

    /**
     * this method reed every line from the text file and sends it to be searched for Hearst patterns.
     * <p>this method closes the given file after being used</p>
     *
     * @param fromFile a File that's inside the corpus to read text from
     */
    public static void handel(File fromFile) {
        BufferedReader bufferedReader = null;
        String paragraph;
        try {
            bufferedReader = new BufferedReader(new FileReader(fromFile));
            NounRelationFinder relationFinder = new NounRelationFinder();
            while ((paragraph = bufferedReader.readLine()) != null) {
                relationFinder.detect(paragraph);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
