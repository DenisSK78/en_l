import by.en.service.pars.ParsLesson;

import java.io.FileNotFoundException;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ParsLesson pars = new ParsLesson();
        Map<Integer, String> lessons = null;
        try {
            lessons = pars.getMurphyLesson();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert lessons != null;
        lessons.forEach((integer, s) -> System.out.println(integer + ":" + s));
    }
}
