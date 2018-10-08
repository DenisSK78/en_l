package dao;

import by.en.config.DataBaseConfig;
import by.en.dao.LearnedDAO;
import by.en.dao.MurphyUnitDAO;
import by.en.dao.UserDAO;
import by.en.entity.Learned;
import by.en.entity.MurphyUnit;
import by.en.entity.User;
import by.en.service.pars.MurphyLessonList;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DataBaseConfig.class})
public class TestsWithContext {

    private Logger logger = Logger.getLogger(TestsWithContext.class);

//    @Autowired
//    MurphyLessonList murphyLessonList;

    @Autowired
    LearnedDAO learnedDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    MurphyUnitDAO murphyUnitDAO;

    @Test
    public void existMurphyUnitsOrAddThem(){

        List<MurphyUnit> murphyUnits = murphyUnitDAO.findAll();

        if (murphyUnits.size()==0){
            List<String> lessons = new MurphyLessonList().getMurphyLesson();

            Stream.iterate(0, x->x+1).limit(lessons.size())
                    .map(i -> new MurphyUnit(i+1, lessons.get(i).split(": ")[1]))
                    .forEach(i -> murphyUnitDAO.save(i));

            murphyUnits = murphyUnitDAO.findAll();
            Assert.assertEquals(murphyUnits.size(), 145);
        }

        Assert.assertEquals(murphyUnits.size(), 145);
    }


    @Test
    public void existLearnedByUserIfNotAddThem(){

        int firstPart = 37;
        Integer [] second = new Integer[]{82,83,84,85,86,87,88,89,90,91};

        User user = userDAO.getById(2L);
        List<Learned> learnedByUser = learnedDAO.getLearnedByUser(user);

        if (learnedByUser.size()==0){

            Integer [] learnedNumber = Stream.concat(
                    Arrays.stream(Stream.iterate(1, x->x+1).limit(firstPart).toArray(Integer[]::new)),
                    Arrays.stream(second)).toArray(Integer[]::new);

            Arrays.stream(learnedNumber)
                    .map(e-> new Learned(0, 0, user, murphyUnitDAO.getUnitByNumber(e)))
                    .forEach(learned -> learnedDAO.save(learned));

            Assert.assertTrue(learnedDAO.getLearnedByUser(user).size()!=0);
        }else {
            Assert.assertTrue(learnedDAO.getLearnedByUser(user).size()!=0);
        }

    }

    @Test
    public void testGetUserByEmail(){
        User user = userDAO.findByEmail("admin@admin.ru");
        logger.info(user);
        assertThat(userDAO, notNullValue());
    }

}
