package by.en.service.pars;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static by.en.service.pars.RootPath.MURPHY_TXT;

public class ParsLesson {

    private Integer count = 0;

    public Map<Integer, String>  getMurphyLesson() throws FileNotFoundException {

        File file = new File(RootPath.PATH, MURPHY_TXT);

        Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)));

        if (file.exists()) {

            scanner.useDelimiter("\"Unit");
            List<String> units = new ArrayList<>();

            while (scanner.hasNext()) {
                String line = scanner.next();
                units.add(line);
            }

            scanner.close();

            return units
                    .stream()
                    .map(s -> s.split("\"}")[0].trim())
                    .map(s -> s.replace(".", ""))
                    .map(s -> s.replace("\uD83D\uDCD8", ""))
                    .map(s -> s.replace("  ", " "))
                    .filter(this::deleteTheSame)
                    .collect(Collectors.toMap(c -> Integer.valueOf(c.split("\\s")[0].trim()), c -> c.replaceFirst("(\\d*? )", " ").trim()));
        }

        return Collections.emptyMap();
    }

    private boolean deleteTheSame(String str){

        int number = Integer.valueOf(str.split(" ")[0].trim());

        if (number != count + 1){
            return false;
        }

        if (number > count) {
            count++;
            return true;
        }

        return false;
    }
}
