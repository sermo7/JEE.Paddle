package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;

import business.api.RestBuilder;
import business.api.Uris;
import business.wrapper.UserWrapper;
import config.ITsApiConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITsApiConfig.class})
public class UserResourceIT {

    private static final String url = "http://localhost:8080/JEE.Paddle.0.0.1-SNAPSHOT" + Uris.SERVLET_MAP;

    @Test
    public void testBadRequestCreate() {
        try {
            UserWrapper userWrapper = new UserWrapper("", "e1", "p1", new GregorianCalendar(1979, 07, 22));
            new RestBuilder<Object>(url).path(Uris.USERS).body(userWrapper).post().build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.BAD_REQUEST, httpError.getStatusCode());
            LogManager.getLogger(this.getClass()).debug(
                    "testBadRequestCreate (" + httpError.getMessage() + "):\n    " + httpError.getResponseBodyAsString());
        }
    }
    
    @Test
    public void testRepeatingFieldCreate() {
        try {
            UserWrapper userWrapper = new UserWrapper("u", "e1", "p1", new GregorianCalendar(1979, 07, 22));
            new RestBuilder<Object>(url).path(Uris.USERS).body(userWrapper).post().build();
            new RestBuilder<Object>(url).path(Uris.USERS).body(userWrapper).post().build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.CONFLICT, httpError.getStatusCode());
            LogManager.getLogger(this.getClass()).debug(
                    "testRepeatingFieldCreate (" + httpError.getMessage() + "):\n    " + httpError.getResponseBodyAsString());
        }
    }
}
