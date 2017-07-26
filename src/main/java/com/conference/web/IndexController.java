package com.conference.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.conference.dao.PresentationDao;
import com.conference.entity.Presentation;
import com.conference.entity.User;
import com.conference.service.PresentationService;
import com.conference.service.UserService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	PresentationService presentationService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PresentationDao presentationDao;
	
	
	
	 @RequestMapping(method = RequestMethod.GET)
	   public String start(Model model){
	    	
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String name = auth.getName();	    	
	        User user= userService.getUser(name);
	        
	    	List<Presentation> presentations = presentationService.findUserPresent(user);
	    	model.addAttribute("presentationsUser", presentations);
	    	Presentation presentAction= new Presentation();
			 model.addAttribute("presentAction", presentAction);
	        return "index";
	    }
	 
	 
	 @RequestMapping(value = { "/delete-present-{id}" }, method = RequestMethod.GET)
		public String deleteUser(@PathVariable String id) {
		 presentationService.deletePresent(id);
			return "redirect:/index";
		}
	 
	 @RequestMapping(value = { "/edit-present" }, method = RequestMethod.GET)
		public String editPresent(@ModelAttribute ("presentation") Presentation presentation, BindingResult result,
				ModelMap model, @PathVariable String id) {
	

			if (result.hasErrors()) {
				return "index";
			}
			
			model.addAttribute("presentation", presentation);
		
			return "index";
		}
	 
		@RequestMapping(value = { "/edit-present" }, method = RequestMethod.POST)
		public String updateUser(@ModelAttribute ("presentAction") Presentation presentation, BindingResult result,
				ModelMap model) {
			
			if (result.hasErrors()) {
				return "redirect:/index";
			}
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        String name = auth.getName();	        
	      
	        Set<User>user = new HashSet<User>();
	        user.add(userService.getUser(name));
	        presentation.setUser(user);
	        
	        int count=0;
	        
	        if (presentation.getId()==null) {
	        
	        	presentationService.createPresent(presentation);
	        return "redirect:/index";}
	        	
	        else {
	            
	    	if(presentation.getSchedule()!=null&&presentation.getRoom()!=null)
	    	count =presentationDao.checkPresent(presentation);
	    	
	    	if (count==1) {	
			presentationService.updatePresent(presentation);
	    	return "redirect:/index";}
	    	else	    	
			return "redirect:/error";
	    	
	        }
		}

}
