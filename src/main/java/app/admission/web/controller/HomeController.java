package app.admission.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("welcomePage");
        return model;
    }

    @RequestMapping(value = {"/homePage"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("home/homePage");
        return model;
    }
}
