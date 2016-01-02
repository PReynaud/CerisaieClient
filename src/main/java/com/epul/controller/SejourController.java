package com.epul.controller;

import com.epul.consumer.Consumer;
import com.epul.metier.Sejour;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Pierre on 18/11/2015.
 */
@Controller
@RequestMapping("/listeSejour")
public class SejourController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printAllSejour() {
        ArrayList<Sejour> listSejour = (ArrayList<Sejour>) Consumer.getAllSejour();

        ModelAndView modelAndView = new ModelAndView("client");
        modelAndView.addObject("listClient", listSejour);

        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView printOneSejour(@PathVariable("id") int id) {
        Sejour sejour = Consumer.getOneSejour(id);

        ModelAndView modelAndView = new ModelAndView("sejour");
        modelAndView.addObject("sejour", sejour);

        return modelAndView;
    }
}
