package dao;

import by.en.config.database.DataBaseConfig;
import by.en.entity.Learned;
import by.en.entity.MurphyUnit;
import by.en.entity.Role;
import by.en.entity.Status;
import by.en.entity.User;
import by.en.service.LearnedService;
import by.en.service.MurphyUnitService;
import by.en.service.UserService;
import by.en.service.util.parser.MurphyLessonList;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DataBaseConfig.class})
public class TestsWithContext {

    private Logger logger = Logger.getLogger(TestsWithContext.class);

//    @Autowired
//    MurphyLessonList murphyLessonList;

    @Autowired
    LearnedService learnedService;

    @Autowired
    UserService userService;

    @Autowired
    MurphyUnitService murphyUnitService;

    @Test
    public void existMurphyUnitsOrAddThem(){

        List<MurphyUnit> murphyUnits = murphyUnitService.findAll();

        if (murphyUnits.size()==0){
            List<String> lessons = new MurphyLessonList().getMurphyLesson();

            Stream.iterate(0, x->x+1).limit(lessons.size())
                    .map(i -> new MurphyUnit(i+1, lessons.get(i).split(": ")[1]))
                    .forEach(i -> murphyUnitService.saveUnit(i));

            murphyUnits = murphyUnitService.findAll();
            Assert.assertEquals(murphyUnits.size(), 145);
        }

        Assert.assertEquals(murphyUnits.size(), 145);
    }

    @Test
    public void testGetUserByEmail(){
        User user = userService.getUserByEmail("admin@admin.ru");
        logger.info(user);
        assertThat(userService, notNullValue());
    }

    @Test
    public void existUserOrAddOneForTestNameUser2(){

        User user = userService.getUserByEmail("user2@user2.by");

        if(user == null) {
            user = new User();
            user.setEmail("user2@user2.by");
            user.setFirstName("User2");
            user.setSurname("User2");
            user.setStatus(Status.OK);
            user.setRole(Role.USER);
            user.setPassword("user2");
            userService.saveUser(user);
            Assert.assertEquals(userService.getUserByEmail("user2@user2.by").getFirstName(), "User2");
        }else {
            Assert.assertEquals(user.getFirstName(), "User2");
        }
    }

    @Test
    public void existLearnedByUserIfNotAddThemForTestUser2(){

        Integer firstPart = 41;
        Integer [] second = new Integer[]{82,83,84,85,86,87,88,89,90,91};

        User user = userService.getUserByEmail("user2@user2.by");
        List<Learned> learnedByUser = learnedService.getLearnedByUser(user);

        if (learnedByUser.size()==0){

            Stream.concat(
                    stream(Stream.iterate(1, x -> x+1).limit(firstPart).toArray(Integer[]::new)),
                    stream(second))
                    .map(e-> new Learned(0, 0, user, murphyUnitService.getUnitByNumber(e)))
                    .forEach(learned -> learnedService.saveLearned(learned));

            Assert.assertEquals(learnedService.getLearnedByUser(user).size(), firstPart+second.length);
        }else {
            // for new if firstPart is growing
            if (learnedService.getLearnedByUser(user).size() < firstPart+second.length) Stream
                    .iterate(1, x -> x + 1)
                    .limit(firstPart + second.length - learnedService.getLearnedByUser(user).size())
                    .map(e -> e + firstPart)
                    .forEach(e -> learnedService.saveLearned(
                            new Learned(0, 0, user, murphyUnitService.getUnitByNumber(e))));
            Assert.assertEquals(learnedService.getLearnedByUser(user).size(), firstPart+second.length);
        }
    }

//    @Test
//    public void addNewLessonIfLengthLearnedForUserLessThanInPreviousTest(){
//
//    }
}
