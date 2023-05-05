package IO;


import DataBase.RelationsDataBase;
import NounPhrasesPackage.Hypernym;
import NounPhrasesPackage.HyponymsCollection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * this class handle the writing strings into text files process.
 *
 * @author ori katzir
 * @version ass7
 * @since 2022/06/15
 */
public class WriteOutDataBase {

    private static final String OUTPUT_TEXT_FILE = "\\hypernym_db.txt";

    /**
     * this method write the content of the database as required.
     *
     * @param pathToOutPut the path of the output file
     */
    public static void write(String pathToOutPut) {
        RelationsDataBase dataBase = RelationsDataBase.getDataBaseInstance();
        BufferedWriter output = null;
        try {
            if(!pathToOutPut.endsWith(OUTPUT_TEXT_FILE)){
                pathToOutPut += OUTPUT_TEXT_FILE;
            }
            File file = new File(pathToOutPut);
            FileWriter fileWriter = new FileWriter(file);
            output = new BufferedWriter(fileWriter);
            dataBase.sortHyponyoCollections();
            List<Map<Hypernym, HyponymsCollection>> maps = dataBase.getListOfMaps();
            for (Map<Hypernym, HyponymsCollection> map : maps) {
                for (Map.Entry<Hypernym, HyponymsCollection> entry : map.entrySet()) {
                    if (entry.getValue().getSize()
                            >= RelationsDataBase.MINIMUM_HYPONYM_REQUIRED_FOR_PRINTING) {
                        String str = entry.getKey().toString()
                                + entry.getValue().toString();
                        output.write(str);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
