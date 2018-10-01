package dao;

import by.en.config.DataBaseConfig;
import by.en.dao.impl.LearnedDAOImpl;
import by.en.service.pars.ParsLesson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.Map;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DataBaseConfig.class})
public class LearnedTest {

    @Autowired
    LearnedDAOImpl learnedDAO;

    private Map<Integer, String> lessons;

    @Test
    public void learnedHasDataIfNotSaveData(){

        ParsLesson pars = new ParsLesson();
        try {
            lessons = pars.getMurphyLesson();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
