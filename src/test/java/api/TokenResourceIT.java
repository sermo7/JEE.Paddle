package api;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.ITsApiConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITsApiConfig.class})
public class TokenResourceIT {

    @Test
    public void testLoginPlayer() {
        String token = new RestService().registerAndLoginPlayer();
        assertTrue(token.length() > 20);
        LogManager.getLogger(this.getClass()).info("testLoginPlayer (token:" + token + ")");
    }
    
    @After
    public void deleteAll() {
        new RestService().deleteAll();
    }

}
