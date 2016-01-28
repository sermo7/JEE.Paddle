package business.api;

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

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.COURTS)
public class CourtResource {

    @Autowired
    private CourtController courtController;

    @RequestMapping(method = RequestMethod.POST)
    public void createCourt(@RequestParam(required = true) int id) throws AlreadyExistCourtException {
        if (!this.courtController.createCourt(new Court(id))) {
            throw new AlreadyExistCourtException();
        }
    }

    @RequestMapping(value = Uris.ID + Uris.ACTIVE, method = RequestMethod.POST)
    public void changeCourtActivationTrue(@PathVariable int id) throws NonExistCourtIdException {
        if(!courtController.changeCourtActivation(id, true)){
            throw new NonExistCourtIdException("id: " + id);
        }
    }

    @RequestMapping(value = Uris.ID + Uris.ACTIVE, method = RequestMethod.DELETE)
    public void changeCourtActivationFalse(@PathVariable int id) throws NonExistCourtIdException {
        if(!courtController.changeCourtActivation(id, true)){
            throw new NonExistCourtIdException("id: " + id);
        }
    }

}
