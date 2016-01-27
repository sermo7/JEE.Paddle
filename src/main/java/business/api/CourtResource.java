package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.AlreadyExistCourtException;
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

}
