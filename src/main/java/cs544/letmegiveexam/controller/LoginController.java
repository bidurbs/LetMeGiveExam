/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.model.User;
import cs544.letmegiveexam.service.UserServices;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import cs544.letmegiveexam.model.Subject;
import cs544.letmegiveexam.service.SubjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nirali_bheda
 */
@Controller
public class LoginController {

    @Autowired
    SubjectService subjectService;

    private UserServices userServices;
    

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model, HttpSession session) {
       
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
    
        if (session.getAttribute("user") == null) {
            User user = userServices.getUserByUsername(name);
            session.setAttribute("user", user);
        }
        //ModelAndView model = new ModelAndView();
        List<Subject> subjects = subjectService.getAllSubjects();
        
//        for (Subject sub : subjects) {
//            System.out.println("Subject:" + sub.getName() + "  Description:" + sub.getDescription());
//
//        }
        model.addAttribute("subjects", subjects);
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

//        @ExceptionHandler(value=NoSuchResourceException.class)
//	public ModelAndView handle(Exception e) {
//		ModelAndView mv = new ModelAndView();
//		mv.getModel().put("e", e);
//		mv.setViewName("noSuchResource");
//		return mv;
//	}
    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginfailed(Model model) {

        return "loginfailed";
    }

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session) {
        session.invalidate();
        return "index";
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public ModelAndView getSubjects() {
        //return "subjects";
        ModelAndView model = new ModelAndView();
        List<Subject> subjects = subjectService.getAllSubjects();
//        System.out.println("Subject List:" + subjects.size());
//        for (Subject sub : subjects) {
//            System.out.println("Subject:" + sub.getName() + "  Description:" + sub.getDescription());
//        }
        model.addObject(subjects);
        return model;
    }

}
