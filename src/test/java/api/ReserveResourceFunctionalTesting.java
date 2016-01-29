package api;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Test;

import business.api.Uris;
import business.wrapper.AvailableTime;

public class ReserveResourceFunctionalTesting {

    RestService restService = new RestService();

    // @Test
    public void testshowAvailability() {
        final int COURTS = 1;
        RestService restService = new RestService();
        for (int i = 0; i < COURTS; i++) {
            restService.createCourt("" + i);
        }
        String token = restService.registerAndLoginPlayer();
        String day = "" + new GregorianCalendar(2016, 00, 29).getTimeInMillis();
        String response = new RestBuilder<String>(RestService.URL).path(Uris.RESERVES).path(Uris.AVAILABILITY).basicAuth(token, "")
                .param("day", day).clazz(String.class).get().build();
        System.out.println(("<<<< " + response));
    }

    @Test
    public void testReserveCourt() {
        // TODO Programando...
        restService.createCourt("1");
        restService.createCourt("2");
        String token = restService.registerAndLoginPlayer();
        Calendar day = new GregorianCalendar(2016, 00, 29, 12, 0);
        new RestBuilder<String>(RestService.URL).path(Uris.RESERVES).basicAuth(token, "").body(new AvailableTime(1, day)).post().build();
        day = new GregorianCalendar(2016, 00, 29, 14, 0);
        new RestBuilder<String>(RestService.URL).path(Uris.RESERVES).basicAuth(token, "").body(new AvailableTime(2, day)).post().build();
    }

    @After
    public void deleteAll() {
        new RestService().deleteAll();
    }

}
