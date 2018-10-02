package by.en.service.pars;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static by.en.service.pars.RootPath.NEW_MURPHY_TXT;

public class MurphyLessonList {

    private static final Logger logger = Logger.getLogger(MurphyLessonList.class);

    public List<String> getMurphyLesson() {

        File file = new File(RootPath.PATH, NEW_MURPHY_TXT);

        if (file.exists()) {

            List<String> units = new ArrayList<>();

            try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)))){

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    units.add(line);
                }

            } catch (FileNotFoundException e) {
                logger.info("File new-murphy.txt doesn't exist!");
                e.printStackTrace();
            }

            return new ArrayList<>(units);
        }
        return Collections.emptyList();
    }
}