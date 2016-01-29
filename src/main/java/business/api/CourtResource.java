package business.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.AlreadyExistCourtException;
import business.api.exceptions.NonExistCourtIdException;
import business.controllers.CourtController;
import business.entities.Court;
import business.wrapper.CourtState;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.COURTS)
public class CourtResource {

    private CourtController courtController;

    @Autowired
    public void setCourtController(CourtController courtController) {
        this.courtController = courtController;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createCourt(@RequestParam(required = true) int id) throws AlreadyExistCourtException {
        if (!this.courtController.createCourt(new Court(id))) {
            throw new AlreadyExistCourtException();
        }
    }

    @RequestMapping(value = Uris.ID + Uris.ACTIVE, method = RequestMethod.POST)
    public void changeCourtActivationTrue(@PathVariable int id) throws NonExistCourtIdException {
        if (!courtController.changeCourtActivation(id, true)) {
            throw new NonExistCourtIdException("id: " + id);
        }
    }

    @RequestMapping(value = Uris.ID + Uris.ACTIVE, method = RequestMethod.DELETE)
    public void changeCourtActivationFalse(@PathVariable int id) throws NonExistCourtIdException {
        if (!courtController.changeCourtActivation(id, true)) {
            throw new NonExistCourtIdException("id: " + id);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CourtState> showCourts() {
        List<Court> courtList = courtController.showCourts();
        List<CourtState> courtStateWrapperList = new ArrayList<>();
        for (Court court : courtList) {
            courtStateWrapperList.add(new CourtState(court.getId(), court.isActive()));
        }
        return courtStateWrapperList;
    }

}
