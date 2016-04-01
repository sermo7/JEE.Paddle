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

import data.daos.ReserveDao;
import data.entities.Reserve;


@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class ReservePresenter {

    @Autowired
    private ServletContext servletContext;
    
    @Autowired
    private ReserveDao reserveDao;


    public ReservePresenter() {
    }

    // Se ejecuta siempre y antes. Añade un atributo al Model
    @ModelAttribute("now")
    public String now() {
        return new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss").format(new Date());
    }

    @RequestMapping("/reserve-list")
    public ModelAndView listReserves(Model model) {
    	ModelAndView modelAndView = new ModelAndView("/jsp/reserveList");
        modelAndView.addObject("reserveList", reserveDao.findAll());
        return modelAndView;
    }
    
    @RequestMapping(value = {"/delete-reserve/{id}"})
    public String deleteReserve(@PathVariable int id, Model model) {
        reserveDao.delete(reserveDao.findOne(id));
        model.addAttribute("reserveList", reserveDao.findAll());
        return "/jsp/reserveList";
    }

    @RequestMapping(value = "/create-reserve", method = RequestMethod.GET)
    public String createReserve(Model model) {
        Reserve newReserve = new Reserve();
    	model.addAttribute("reserve", newReserve);
        return "/jsp/createReserve";
    }  
    

}
