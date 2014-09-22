/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.model.User;
import cs544.letmegiveexam.service.UserServices;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nirali_bheda
 */
@Controller
public class LoginController {
    
         private UserServices userServices;
        
         
        @RequestMapping(value="/welcome", method=RequestMethod.GET)
        public String welcome(HttpSession session){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();
            System.out.println(name);
           
//            HttpSession session=(HttpSession) sessionFactory.getCurrentSession();
           if(session.getAttribute("user")==null){
               User user= userServices.getUserByUsername(name);
               session.setAttribute("user", user);
           }
            
            return "welcome";
        }
        
        @RequestMapping(value="/login", method=RequestMethod.GET)
        public String index(){
            return "login";
        }
        
        
//        @ExceptionHandler(value=NoSuchResourceException.class)
//	public ModelAndView handle(Exception e) {
//		ModelAndView mv = new ModelAndView();
//		mv.getModel().put("e", e);
//		mv.setViewName("noSuchResource");
//		return mv;
//	}
        @RequestMapping(value="/loginfailed", method=RequestMethod.GET)
	public String loginfailed(Model model) {
		
		return "loginfailed";
	}

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }
    @RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "index";
	}
    
        
}
