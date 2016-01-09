package com.epul.controller;

import com.epul.consumer.Consumer;
import com.epul.metier.Client;
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
@RequestMapping("/listeClient")
public class ClientController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printAllClient() {
        ArrayList<Client> listClient = (ArrayList<Client>) Consumer.getAllClient();

        ModelAndView modelAndView = new ModelAndView("client");
        modelAndView.addObject("listClient", listClient);

        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView printOneClient(@PathVariable("id") int id) {
        Client client = Consumer.getOneClient(id);

        ModelAndView modelAndView = new ModelAndView("client");
        modelAndView.addObject("client", client);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteOneClient(@PathVariable("id") int id){
        Boolean res = Consumer.deleteClient(id);

        ModelAndView modelAndView = new ModelAndView("deleteClient");
        modelAndView.addObject("result", res);

        return modelAndView;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateOneClient(@PathVariable("id") int id){
        Client client = Consumer.getOneClient(id);

        ModelAndView modelAndView = new ModelAndView("updateClient");
        modelAndView.addObject("client", client);

        return modelAndView;
    }
}
