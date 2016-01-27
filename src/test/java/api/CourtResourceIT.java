package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;

import business.api.RestBuilder;
import business.api.Uris;
import business.wrapper.TokenWrapper;
import config.ITsApiConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITsApiConfig.class})
public class CourtResourceIT {

    private static final String url = "http://localhost:8080/JEE.Paddle.0.0.1-SNAPSHOT" + Uris.SERVLET_MAP;

    @Test
    public void testCreateCourtUnauthorized() {
        try {
            new RestBuilder<Object>(url).path(Uris.COURTS).param("id", "1").post().build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.UNAUTHORIZED, httpError.getStatusCode());
            LogManager.getLogger(this.getClass()).debug(
                    "testCreateCourt (" + httpError.getMessage() + "):\n    " + httpError.getResponseBodyAsString());
        }
    }
    
    @Test
    public void testCreateCourt() {
        TokenWrapper token = new RestBuilder<TokenWrapper>(url).path(Uris.TOKENS).basicAuth("admin", "admin").clazz(TokenWrapper.class)
                .post().build();
        new RestBuilder<Object>(url).path(Uris.COURTS).param("id", "1").basicAuth(token.getToken(), "admin").post().build();
        //Falta meter el token en cabecera y tantear crear una pista....
    }

}
