package dao;

import by.en.config.DataBaseConfig;
import by.en.dao.impl.MurphyUnitDAOImpl;
import by.en.entity.MurphyUnit;
import by.en.service.pars.ParsLesson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DataBaseConfig.class})
public class MurphyUnitTest {

    @Autowired
    MurphyUnitDAOImpl murphyUnitDAO;

    private Map<Integer, String> lessons;

    @Test
    public void hasMurphyDataOrAdd(){

        List<MurphyUnit> units = murphyUnitDAO.findAll();
        if (units.size()==145){
            units.forEach(System.out::println);
            System.out.println("OK");
        }else {

            ParsLesson pars = new ParsLesson();
            try {
                lessons = pars.getMurphyLesson();
                lessons.forEach((k,v)-> System.out.println(k.toString() + " " + v));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


            lessons.forEach((key, value) -> murphyUnitDAO.save(new MurphyUnit(key, value)));
        }
    }
}
