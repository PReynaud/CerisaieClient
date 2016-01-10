package com.epul.controller;

import com.epul.consumer.Consumer;
import com.epul.metier.Facture;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Laura on 10/01/2016.
 */
@Controller
@RequestMapping("/Facture")
public class FactureController {
    @RequestMapping(value = "/{numSej}", method = RequestMethod.GET)
    public ModelAndView printAllActivite(@PathVariable("numSej")int numSej) {
        Facture facture =  Consumer.getTarifForSejour(numSej);

        ModelAndView modelAndView = new ModelAndView("facture");
        modelAndView.addObject("facture", facture);

        return modelAndView;
    }

}
