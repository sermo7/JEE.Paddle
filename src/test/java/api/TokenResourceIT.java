package api;

import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import business.api.RestBuilder;
import business.api.Uris;
import business.wrapper.UserWrapper;
import config.ITsApiConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITsApiConfig.class})
public class TokenResourceIT {

    private static final String url = "http://localhost:8080/JEE.Paddle.0.0.1-SNAPSHOT" + Uris.SERVLET_MAP;

    @Test
    public void testLoginOK() {
        UserWrapper userWrapper = new UserWrapper("usu1", "usu1@gmail.com", "1234", new GregorianCalendar(1979, 07, 22));
        new RestBuilder<Object>(url).path(Uris.USERS).body(userWrapper).post().build();
        String token = new RestBuilder<String>(url).path(Uris.TOKENS).basicAuth("usu1", "1234").clazz(String.class)
                .post().build();
        assertTrue(token.length() > 20);
        LogManager.getLogger(this.getClass()).debug("testLoginOK (token:" + token);
    }

}
