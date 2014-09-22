/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.controller;

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
    private SubjectService subjectService;
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        System.out.println("Subject List");
        //ModelAndView model = new ModelAndView();
        List<Subject> subjects = subjectService.getAllSubjects();
        System.out.println("Subject List:" + subjects.size());
        for (Subject sub : subjects) {
            System.out.println("Subject:" + sub.getName() + "  Description:" + sub.getDescription());
        }
        model.addAttribute("subjects", subjects);
        return "welcome";
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public ModelAndView getSubjects() {
        //return "subjects";
        ModelAndView model = new ModelAndView();
        List<Subject> subjects = subjectService.getAllSubjects();
        System.out.println("Subject List:" + subjects.size());
        for (Subject sub : subjects) {
            System.out.println("Subject:" + sub.getName() + "  Description:" + sub.getDescription());
        }
        model.addObject(subjects);
        return model;
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginfailed(Model model) {

        return "loginfailed";
    }
}
