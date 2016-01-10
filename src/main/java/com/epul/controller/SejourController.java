package com.epul.controller;

import com.epul.consumer.Consumer;
import com.epul.metier.Client;
import com.epul.metier.EmplacementTypeEmplacement;
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
        ArrayList<Client> listClient = (ArrayList<Client>) Consumer.getAllClient();
        ArrayList<EmplacementTypeEmplacement> emplacements = (ArrayList<EmplacementTypeEmplacement>) Consumer.getAllEmplacement();
        ModelAndView modelAndView = new ModelAndView("sejour");
        modelAndView.addObject("listSejour", listSejour);
        modelAndView.addObject("listClient", listClient);
        modelAndView.addObject("listEmplacement", emplacements);

        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView printOneSejour(@PathVariable("id") int id) {
        Sejour sejour = Consumer.getOneSejour(id);

        ModelAndView modelAndView = new ModelAndView("sejour");
        modelAndView.addObject("sejour", sejour);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteOneSejour(@PathVariable("id") int id){
        Boolean res = Consumer.deleteSejour(id);

        ModelAndView modelAndView = new ModelAndView("deleteSejour");
        modelAndView.addObject("result", res);

        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateOneSejour(@PathVariable("id") int id){
        ArrayList<Client> listClient = (ArrayList<Client>) Consumer.getAllClient();
        Sejour sejour = Consumer.getOneSejour(id);

        ModelAndView modelAndView = new ModelAndView("updateSejour");
        modelAndView.addObject("sejour", sejour);
        modelAndView.addObject("listClient", listClient);

        return modelAndView;
    }
}
