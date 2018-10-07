package dao;

import by.en.dao.ReadOkDAO;
import by.en.entity.ReadOk;
import by.en.entity.User;
import by.en.service.pars.MurphyLessonList;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ReadOkTest extends BaseTestWithContext{

    @Autowired
    ReadOkDAO readOkDAO;

    @Test
    public void saveNew(){

        User user = userDAO.getById(2L);

        Stream.iterate(0, x->x+1).limit(murphyLessonList.getMurphyLesson().size())
        .forEach(i -> readOkDAO.save(new ReadOk(murphyLessonList.getMurphyLesson().get(i), i+1, 0, user)));

    }
}
