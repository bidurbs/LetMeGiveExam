/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.model.Question;
import cs544.letmegiveexam.model.Subject;
import cs544.letmegiveexam.service.QuestionService;
import cs544.letmegiveexam.service.SubjectService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    public String addSubject(@Valid Subject subject, BindingResult result) {
        if (result.hasErrors()) {
            return "addSubject";
        } else {
            subjectService.addSubject(subject);
            return "redirect:/questionSetting";
        }
    }
    
     @RequestMapping(value = "addQuestion", method = RequestMethod.GET)
    public String addQuestion(Model model) {
        model.addAttribute("queston", new Question());
        return "addQuestion";
    }

    @RequestMapping(value = "addSubject", method = RequestMethod.GET)
    public String addSubject(Model model) {
        model.addAttribute("subject", new Subject());
        return "addSubject";
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public String addQuestion(@Valid Question question, BindingResult result) {
        if (result.hasErrors()) {
            return "addQuestion";
        } else {
            String correctResult = question.getCorrectAnswer();
            if (correctResult.equals("option1")) {
                question.setCorrectAnswer(question.getOption1());
            } else if (correctResult.equals("option2")) {
                question.setCorrectAnswer(question.getOption2());
            } else if (correctResult.equals("option3")) {
                question.setCorrectAnswer(question.getOption3());
            } else if (correctResult.equals("option4")) {
                question.setCorrectAnswer(question.getOption4());
            }
            Subject subject = (Subject) subjectService.getSubjectById(question.getSubjectId());
            question.setSubject(subject);
            questionService.addQuestion(question);
            System.out.println("Saved");
            return "redirect:/adminPanel";
        }
    }

    @RequestMapping(value = "/adminSubjects", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("subjects", subjectService.getAll());
        return "subjectList";
    }

    @RequestMapping(value = "/adminPanel", method = RequestMethod.GET)
    public String admin() {
        return "adminPanel";
    }

    @RequestMapping(value = "/questionSetting", method = RequestMethod.GET)
    public String QuestionSetting(Model model) {
        model.addAttribute("subjects", subjectService.getAll());
        model.addAttribute("question", new Question());
        return "addQuestion";
    }
}
