package IO;

import java.io.File;

/**
 * this class used for handeling every text file in the given corpus.
 * <p>every file is handled by the IO.TextHandler class</p>
 *
 * @author ori katzir
 * @version ass7
 * @see TextHandler
 * @since 2022/06/15
 */
public class CorpusHandler {

    /**
     * this method is used to handle every text file in the given corpus directory.
     *
     * @param corpusPath the relative path of the corpus
     */
    public static void handle(String corpusPath) {
        try {
        File dir = new File(corpusPath);
        File[] files = dir.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    TextHandler.handel(file);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
