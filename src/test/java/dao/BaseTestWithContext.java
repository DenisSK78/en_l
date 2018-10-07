package dao;

import by.en.config.DataBaseConfig;
import by.en.dao.UserDAO;
import by.en.service.pars.MurphyLessonList;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DataBaseConfig.class})
public class BaseTestWithContext {

    @Autowired
    UserDAO userDAO;

    @Autowired
    MurphyLessonList murphyLessonList;
}
