package com.epul.controller;

import com.epul.consumer.Consumer;
import com.epul.metier.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");

        Client client = new Consumer("http://localhost:8080/Clients/").getOneClient(1);


        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("client", client);

        return modelAndView;
	}
}