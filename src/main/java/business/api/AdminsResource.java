package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.controllers.AdminController;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.ADMINS)
public class AdminsResource {

    @Autowired
    private AdminController adminController;

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllExceptAdmin() {
        adminController.deleteAllExceptAdmin();
    }

}
