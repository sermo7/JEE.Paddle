package business.api;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.InvalidCourtReserveException;
import business.api.exceptions.InvalidDateException;
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
    public Availability showAvailability(@RequestParam(defaultValue = "-1") long day) throws InvalidDateException {
        Calendar calendarDay = Calendar.getInstance();
        if (day != -1) {
            calendarDay.setTimeInMillis(day);
            this.validateDay(calendarDay);
        }
        calendarDay.set(Calendar.HOUR, 0);
        calendarDay.set(Calendar.MINUTE, 0);
        calendarDay.set(Calendar.SECOND, 0);
        calendarDay.set(Calendar.MILLISECOND, 0);
        //TODO controlar que no es un dia pasado
        return reserveController.showAvailability(calendarDay);
    }
    
    private void validateDay(Calendar day) throws InvalidDateException{
        if(Calendar.getInstance().after(day)){
            throw new InvalidDateException("La fecha no puede ser pasada");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void reserveCourt(@RequestBody AvailableTime availableTime) throws InvalidCourtReserveException, InvalidDateException {
        Court court = courtController.read(availableTime.getCourtId());
        if (court == null) {
            throw new InvalidCourtReserveException("" + availableTime.getCourtId());
        }
        Calendar date = availableTime.getTime();
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        if (date.get(Calendar.HOUR_OF_DAY) < 9 || date.get(Calendar.HOUR_OF_DAY) > 23) {
            throw new InvalidCourtReserveException(date.get(Calendar.HOUR_OF_DAY) + " fuera de rango");
        }
       this.validateDay(date);
        Reserve reserve = new Reserve(court, date);
        if (!reserveController.reserveCourt(reserve)) {
            throw new InvalidCourtReserveException(availableTime.getCourtId() + "-" + availableTime.getTime());

        }
    }
}
