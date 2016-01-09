package com.epul.controller;

import com.epul.consumer.Consumer;
import com.epul.metier.Activite;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Laura on 09/01/2016.
 */
@Controller
@RequestMapping("/listeActivite")
public class ActiviteController {

    @RequestMapping(value = "/{numSejour}", method = RequestMethod.GET)
    public ModelAndView printAllActivite(@PathVariable("numSejour")int numSejour) {
        ArrayList<Activite> listActivite = (ArrayList<Activite>) Consumer.getAllActiviteForSejour(numSejour);

        ModelAndView modelAndView = new ModelAndView("activite");
        modelAndView.addObject("listActivite", listActivite);

        return modelAndView;
    }

}
