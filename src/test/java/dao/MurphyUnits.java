package dao;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class MurphyUnits extends BaseTestWithContext {

    @Test
    public void getMurphyUnitsFromContext(){
        List<String> unitList = murphyLessonList.getMurphyLesson();
        murphyLessonList.getMurphyLesson().forEach(System.out::println);
        Assert.assertEquals(unitList.size(), 145);
    }
}
