package dao;

import by.en.config.DataBaseConfig;
import by.en.dao.UserDAO;
import by.en.entity.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:application-context.xml"})
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DataBaseConfig.class})
public class UserDaoTest {

    @Autowired
    private UserDAO userDAO;

    Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testSmth(){
        User user = userDAO.findByEmail("admin@admin.ru");
        logger.info(user);

        assertThat(userDAO, notNullValue());
    }
}
