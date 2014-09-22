/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.model.Subject;
import cs544.letmegiveexam.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Arjun
 */
@Controller
public class AdminController {
    @Autowired
    SubjectService subjectService;
    
     @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
        public String addSubject(Subject subject){
            subjectService.saveSubject(subject);
            return "adminPanel";
        }
        
        
        @RequestMapping(value="/adminSubjects", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("subjects", subjectService.getAll());
		return "subjectList";
	}
}
