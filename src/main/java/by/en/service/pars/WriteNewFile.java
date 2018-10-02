package by.en.service.pars;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteNewFile {
    private String src = "src";
    private String main = "main";
    private String resources = "resources";
    private File path = new File(src + File.separator + main + File.separator + resources);

    public void write() {

        ParsLesson pars = new ParsLesson();
        Map<Integer, String> lessons = null;
        try {
            lessons = pars.getMurphyLesson();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert lessons != null;
        lessons.forEach((integer, s) -> System.out.println(integer + ":" + s));

        File file = new File(path, "new-murphy.txt");
        try {
            FileWriter fw = new FileWriter(file);
            if (!file.exists()) {
                System.out.println(file.createNewFile());
            }
            lessons.forEach((k,v)-> {
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
