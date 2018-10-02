package dao;

import by.en.dao.impl.LearnedDAOImpl;
import by.en.service.pars.ParsLesson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.util.Map;

public class LearnedTest extends BaseTestWithContext{

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
