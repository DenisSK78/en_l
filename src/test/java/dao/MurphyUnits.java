package dao;

import by.en.service.pars.MurphyLessonList;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class MurphyUnits extends BaseTestWithContext {

    @Autowired
    MurphyLessonList murphyLessonList;

    @Test
    public void getMurphyUnitsFromContext(){
        List<String> unitList = murphyLessonList.getMurphyLesson();
        murphyLessonList.getMurphyLesson().forEach(System.out::println);
        Assert.assertEquals(unitList.size(), 145);
    }
}
