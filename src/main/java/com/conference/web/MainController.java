package com.conference.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.conference.entity.Presentation;
import com.conference.service.PresentationService;


@Controller
	@RequestMapping("/")
	public class MainController {
	
	@Autowired
	PresentationService presentationService;
	 
	    @RequestMapping(method = RequestMethod.GET)
	    public String start(Model model){
	    	
	    	List<Presentation> presentations = presentationService.findAllPresentation();
	    	model.addAttribute("presentations", presentations);
	        return "presentations";
	    }
	 
	}


