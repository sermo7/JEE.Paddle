package data.daos;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.entities.User;
import config.PersistenceConfig;
import config.TestsPersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class UserDaoITest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testCreate() {
        userDao.save(new User("u","e","p",Calendar.getInstance()));
        assertEquals(1, userDao.count());
    }

    @After
    public void deleteAll() {
        userDao.deleteAll();
    }

}
