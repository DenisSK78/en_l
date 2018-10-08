package by.en.service.util.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static by.en.service.util.parser.RootPath.NEW_MURPHY_TXT;
import static by.en.service.util.parser.RootPath.PATH;

public class WriteNewFile {

    public void write() {

        ParsLesson pars = new ParsLesson();
        Map<Integer, String> lessons = null;
        try {
            lessons = pars.getMurphyLesson();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        File file = new File(PATH, NEW_MURPHY_TXT);

        try (FileWriter fw = new FileWriter(file)){

            assert lessons != null;
            lessons.forEach((k, v)-> {
                try {
                    fw.write(k.toString() + ": " + v + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
