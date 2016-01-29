package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.entities.Court;
import business.wrapper.CourtState;
import data.daos.CourtDao;

@Controller
public class CourtController {

    private CourtDao courtDao;

    @Autowired
    public void setCourtDao(CourtDao courtDao) {
        this.courtDao = courtDao;
    }

    public boolean createCourt(Court court) {
        if (courtDao.exists(court.getId())) {
            return false;
        } else {
            courtDao.save(court);
            return true;
        }
    }

    public boolean changeCourtActivation(int id, boolean active) {
        Court court = courtDao.findOne(id);
        if (court == null) {
            return false;
        } else {
            court.setActive(active);
            courtDao.save(court);
            return true;
        }
    }

    public List<CourtState> showCourts() {
        List<CourtState> courtStateList = new ArrayList<>();
        for (Court court : courtDao.findAll()) {
            courtStateList.add(new CourtState(court));
        }
        return courtStateList;
    }

    public Court read(int courtId) {
        return courtDao.findOne(courtId);
    }

}
