package dao;

import by.en.dao.UserDAO;
import by.en.entity.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;


public class UserDaoTest extends BaseTestWithContext{

    @Autowired
    private UserDAO userDAO;

    private Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testSmth(){
        User user = userDAO.findByEmail("admin@admin.ru");
        logger.info(user);

        assertThat(userDAO, notNullValue());
    }
}
