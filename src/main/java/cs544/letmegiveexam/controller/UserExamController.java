/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.model.UserExam;
import cs544.letmegiveexam.service.UserExamService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bidur
 */
@Controller
@Scope("session")
public class UserExamController {
    
    @Autowired
    UserExamService userExamService;
    
    @RequestMapping(value = "/polupateResult/{Id}", method = RequestMethod.POST)
    public String startExam(Model model, HttpServletRequest request, @PathVariable long Id) {
        UserExam userExam = new UserExam();
        userExamService.saveUserExam(userExam);
        return "redirect:/examHistory";
    }
    
}
