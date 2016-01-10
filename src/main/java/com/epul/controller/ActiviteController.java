package com.epul.controller;

import com.epul.consumer.Consumer;
import com.epul.metier.Activite;
import com.epul.metier.Sejour;
import com.epul.metier.Sport;
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
        ArrayList<Sport> listSport = (ArrayList<Sport>) Consumer.getAllSport();

        ModelAndView modelAndView = new ModelAndView("activite");
        modelAndView.addObject("listActivite", listActivite);
        modelAndView.addObject("listSport", listSport);
        modelAndView.addObject("numSejour", numSejour);

        return modelAndView;
    }

    @RequestMapping(value = "/{idSejour}/delete/{idSport}/{date}", method = RequestMethod.GET)
    public ModelAndView deleteOneActivite(@PathVariable("idSejour") int idSejour, @PathVariable("idSport") int idSport, @PathVariable ("date") String date){
        Boolean res = Consumer.deleteActivite(idSejour, idSport, date);

        ModelAndView modelAndView = new ModelAndView("deleteSejour");
        modelAndView.addObject("result", res);

        return modelAndView;
    }
}
