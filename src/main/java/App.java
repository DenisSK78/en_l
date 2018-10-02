import by.en.service.pars.MurphyLessonList;
import by.en.service.pars.WriteNewFile;

import java.util.List;

public class App {
    public static void main(String[] args) {
        WriteNewFile wF = new WriteNewFile();
        wF.write();
//-------------------------------
//        List<String> lesson = new MurphyLessonList().getMurphyLesson();
//        lesson.forEach(System.out::println);
    }
}
