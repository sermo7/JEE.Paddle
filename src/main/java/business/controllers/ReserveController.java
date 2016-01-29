package business.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.daos.ReserveDao;
import business.entities.Reserve;
import business.wrapper.Availability;

@Controller
public class ReserveController {

    private ReserveDao reserveDao;

    @Autowired
    public void setReserveDao(ReserveDao reserveDao) {
        this.reserveDao = reserveDao;
    }

    public Availability showAvailability(Calendar calendarDay) {
        // TODO
        return null;
    }

    public boolean reserveCourt(Reserve reserve) {
        // TODO Falta comprobar que la reserva no este ocupada
        reserveDao.save(reserve);
        return true;
    }

}
