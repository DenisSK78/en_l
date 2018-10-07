package dao;

import by.en.dao.LearnedDAO;
import by.en.entity.Learned;
import by.en.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Stream;

public class LearnedTest extends BaseTestWithContext{

    @Autowired
    LearnedDAO learnedDAO;


    @Test
    public void smthLearned(){
        int firstPart = 37;
        Integer [] second = new Integer[]{82,83,84,85,86,87,88,89,90,91};
        User user = userDAO.getById(2L);

        Integer [] learnedNumber = Stream.concat(Arrays.stream(Stream.iterate(1, x->x+1).limit(firstPart).toArray(Integer[]::new)),
                Arrays.stream(second)).toArray(Integer[]::new);

        Arrays.stream(learnedNumber)
                .map(e-> new Learned(e , 0, 0, user))
//                .forEach(learned -> learnedDAO.save(learned));
                .forEach(System.out::println);
    }
}



