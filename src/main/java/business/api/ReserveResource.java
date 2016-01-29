package business.api;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.InvalidCourtReserveException;
import business.controllers.CourtController;
import business.controllers.ReserveController;
import business.entities.Court;
import business.entities.Reserve;
import business.wrapper.Availability;
import business.wrapper.AvailableTime;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.RESERVES)
public class ReserveResource {

    private ReserveController reserveController;

    private CourtController courtController;

    @Autowired
    public void setCourtController(CourtController courtController) {
        this.courtController = courtController;
    }

    @Autowired
    public void setReserveController(ReserveController reserveController) {
        this.reserveController = reserveController;
    }

    @RequestMapping(value = Uris.AVAILABILITY, method = RequestMethod.GET)
    public Availability showAvailability(@RequestParam(defaultValue = "-1") long day) {
        Calendar calendarDay = Calendar.getInstance();
        if (day != -1) {
            calendarDay.setTimeInMillis(day);
        }
        return reserveController.showAvailability(calendarDay);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void reserveCourt(@RequestBody AvailableTime availableTime) throws InvalidCourtReserveException {
        Court court = courtController.read(availableTime.getCourtId());
        if (court == null) {
            throw new InvalidCourtReserveException("" + availableTime.getCourtId());
        } else {
            //TODO falta normalizar la hora de la reserva
            Reserve reserve= new Reserve(court, availableTime.getTime());
            if (!reserveController.reserveCourt(reserve)) {
                throw new InvalidCourtReserveException(availableTime.getCourtId() + "-" + availableTime.getTime());
            }
        }
    }
}
