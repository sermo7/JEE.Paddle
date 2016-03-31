package web;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import data.daos.CourtDao;
import data.entities.Court;


@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class CourtPresenter {

    @Autowired
    private ServletContext servletContext;
    
    @Autowired
    private CourtDao courtDao;


    public CourtPresenter() {
    }

    // Se ejecuta siempre y antes. Añade un atributo al Model
    @ModelAttribute("now")
    public String now() {
        return new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss").format(new Date());
    }

    @RequestMapping("/court-list")
    public ModelAndView listCourts(Model model) {
    	ModelAndView modelAndView = new ModelAndView("/jsp/courtList");
        modelAndView.addObject("courtList", courtDao.findAll());
        return modelAndView;
    }
    
    @RequestMapping(value = {"/delete-court/{id}"})
    public String deleteCourt(@PathVariable int id, Model model) {
        courtDao.delete(courtDao.findOne(id));
        model.addAttribute("courtList", courtDao.findAll());
        return "/jsp/courtList";
    }

    @RequestMapping(value = "/create-court", method = RequestMethod.GET)
    public String createCourt(Model model) {
        Court newCourt = new Court();
    	model.addAttribute("court", newCourt);
        return "/jsp/createCourt";
    }  
    

}
