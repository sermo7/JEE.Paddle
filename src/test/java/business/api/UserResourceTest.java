package business.api;

import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.api.exceptions.AlreadyExistUserFieldException;
import business.api.exceptions.InvalidUserFieldException;
import business.wrapper.UserWrapper;
import config.TestsApiConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestsApiConfig.class})
public class UserResourceTest {

    @Autowired
    private UserResource userResource;

    @Test
    public void testBadRequestCreate() throws AlreadyExistUserFieldException {
        try {
            UserWrapper userWrapper = new UserWrapper("", "e1", "p1", new GregorianCalendar(1979, 07, 22));
            userResource.create(userWrapper);
            fail();
        } catch (InvalidUserFieldException exception) {
            LogManager.getLogger(this.getClass()).debug("testBadRequestCreate (" + exception.getMessage() + ")");
        }
    }

    @Test
    public void testRepeatingFieldCreate() throws InvalidUserFieldException {
        try {
            UserWrapper userWrapper = new UserWrapper("u", "e1", "p1", new GregorianCalendar(1979, 07, 22));
            userResource.create(userWrapper);
            fail();
        } catch (AlreadyExistUserFieldException exception) {
            LogManager.getLogger(this.getClass()).debug("testBadRequestCreate (" + exception.getMessage() + ")");
        }
    }
}
