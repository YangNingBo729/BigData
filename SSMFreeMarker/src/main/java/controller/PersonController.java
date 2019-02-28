package controller;

import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/getPerson")
    public ModelAndView getPerson(ModelAndView mav) {
        Person person = personService.selectById("2");
        mav.setViewName("index");
        mav.addObject("id", person.getId());
        mav.addObject("name", person.getName());
        mav.addObject("password", person.getPassword());
        return mav;
    }

}
