package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;

import business.api.Uris;
import config.ITsApiConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ITsApiConfig.class})
public class CourtResourceIT {

    @Test
    public void testCreateCourt() {
        new RestService().createCourt("1");
    }

    @Test
    public void testCreateCourtUnauthorized() {
        try {
            new RestBuilder<Object>(RestService.URL).path(Uris.COURTS).param("id", "1").post().build();
            fail();
        } catch (HttpClientErrorException httpError) {
            assertEquals(HttpStatus.UNAUTHORIZED, httpError.getStatusCode());
            LogManager.getLogger(this.getClass()).info(
                    "testCreateCourt (" + httpError.getMessage() + "):\n    " + httpError.getResponseBodyAsString());
        }
    }

    @Test
    public void testChangeCourtActivationTrue() {
        RestService restService = new RestService();
        restService.createCourt("1");
        String token = restService.loginAdmin();
        new RestBuilder<Object>(RestService.URL).path(Uris.COURTS).pathId(1).path(Uris.ACTIVE).basicAuth(token, "admin").post().build();
    }

    @Test
    public void testChangeCourtActivationFalse() {
        RestService restService = new RestService();
        restService.createCourt("1");
        String token = restService.loginAdmin();
        new RestBuilder<Object>(RestService.URL).path(Uris.COURTS).pathId(1).path(Uris.ACTIVE).basicAuth(token, "admin").delete().build();
    }

    @Test
    public void testChangeCourtActivationTrueUnauthorization() {
        RestService restService = new RestService();
        restService.createCourt("1");
        String token = restService.registerAndLoginPlayer();
        try {
            new RestBuilder<Object>(RestService.URL).path(Uris.COURTS).pathId(1).path(Uris.ACTIVE)
                    .basicAuth(token, restService.defaultPlayer().getUsername()).post().build();
        } catch (HttpClientErrorException httpError) {
            LogManager.getLogger(this.getClass()).info(
                    "testChangeCourtActivationTrueUnauthorization (" + httpError.getMessage() + "):\n    "
                            + httpError.getResponseBodyAsString());
        }
    }

    @After
    public void deleteAll() {
        new RestService().deleteAll();
    }

}
