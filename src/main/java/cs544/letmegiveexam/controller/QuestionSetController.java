/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.model.Question;
import cs544.letmegiveexam.model.QuestionSet;
import cs544.letmegiveexam.model.UserExam;
import cs544.letmegiveexam.service.QuestionService;
import cs544.letmegiveexam.service.QuestionSetService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

public class QuestionSetController {
    @Autowired
    QuestionService questionService;
    
    @Autowired
    QuestionSetService questionSetService;
    
    private QuestionSet questionSet;
    
    private UserExam userExam;
    
    @RequestMapping(value = "/questionSet/{Id}", method = RequestMethod.GET)
    public String createQuestionSet(Model model, HttpServletRequest request, @PathVariable long Id) {
        
        List<Question> questionList = questionService.getQuestionsBySubjectId(Id);
        
        questionSet.setQuestionslist(questionList);
        questionSetService.saveQuestionSet(questionSet);
        
        model.addAttribute("questions", questionList);
        
        model.addAttribute("questionSet", questionSet);
        

        //System.out.println(questionService.getQuestionsBySubjectId(Id));
        return "listQuestion";
    }

    public QuestionSet getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(QuestionSet questionSet) {
        this.questionSet = questionSet;
    }
    
    
}
