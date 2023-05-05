import IO.CorpusHandler;
import IO.WriteOutDataBase;

/**
 * a class who has a main method to creat the dataBase instance.
 *
 * @author ori katzir
 * @version ass7
 * @since 2022/06/15
 */
public class CreateHypernymDatabase {

    /**
     * a method that takes the given corpus path and creat a database with the files in the corpus.
     *
     * @param corpusPath a path to the path of the corpus
     */
    public static void creat(String corpusPath) {
        CorpusHandler.handle(corpusPath);
    }

    /**
     * a main method.
     *
     * @param args first arg element is a path to the corpus, the second is a path to where the output file will be
     */
    public static void main(String[] args) {
        creat(args[0]);
        WriteOutDataBase.write(args[1]);
    }
}
