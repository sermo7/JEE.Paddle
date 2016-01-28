package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.services.PaddleService;

@Controller
public class AdminController {
    
    @Autowired
    private PaddleService paddleService;
    
    public void deleteAllExceptAdmin() {
        paddleService.deleteAllExceptAdmin();
    }

}
