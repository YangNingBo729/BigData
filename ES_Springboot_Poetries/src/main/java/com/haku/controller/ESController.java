package com.haku.controller;

import com.haku.dao.es.PoetryRepository;
import com.haku.entity.PoetryES;
import com.haku.repository.CustomPoetryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/search")
public class ESController {
    @Autowired
    private PoetryRepository repository;
    @Autowired
    private CustomPoetryRepository customPoetryRepository;

    @GetMapping("/{type}/{key}")
    public ModelAndView search(@PathVariable(value = "type") String type, @PathVariable(value = "key") String key, ModelAndView mav) {
        System.out.println(type + "     " + key);
        List<PoetryES> poetryESList = customPoetryRepository.search(type, key);
        mav.setViewName("result");
        mav.addObject("result", poetryESList);
        return mav;
    }
}
