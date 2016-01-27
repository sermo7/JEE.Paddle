package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.entities.Court;
import data.daos.CourtDao;

@Controller
public class CourtController {

    @Autowired
    private CourtDao courtDao;

    public boolean createCourt(Court court) {
        if (courtDao.findOne(court.getId()) != null) {
            return false;
        } else {
            courtDao.save(court);
            return true;
        }
    }

}
