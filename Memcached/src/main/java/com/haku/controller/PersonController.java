package com.haku.controller;

import com.haku.entity.Person;
import com.haku.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/select")
    @ResponseBody
    public Object selectPerson() {
        Person person = personService.selectByPrimaryKey(2);
        return person;
    }
}
