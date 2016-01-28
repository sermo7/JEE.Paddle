package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.entities.Court;
import data.daos.CourtDao;

@Controller
public class CourtController {

    private CourtDao courtDao;

    @Autowired
    public void setCourtDao(CourtDao courtDao) {
        this.courtDao = courtDao;
    }

    public boolean createCourt(Court court) {
        if (courtDao.findOne(court.getId()) == null) {
            courtDao.save(court);
            return true;
        } else {
            return false;
        }
    }

    public boolean changeCourtActivation(int id, boolean active) {
        Court court = courtDao.findOne(id);
        if (court != null) {
            court.setActive(active);
            courtDao.save(court);
            return true;
        } else {
            return false;
        }
    }

}
