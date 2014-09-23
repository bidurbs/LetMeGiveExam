/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.model.Question;
import cs544.letmegiveexam.model.QuestionSet;
import cs544.letmegiveexam.model.User;
import cs544.letmegiveexam.model.UserExam;
import cs544.letmegiveexam.service.QuestionService;
import cs544.letmegiveexam.service.QuestionSetService;
import cs544.letmegiveexam.service.UserExamService;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

public class QuestionSetController implements Serializable {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionSetService questionSetService;

    @Autowired
    UserExamService userExamService;

    @RequestMapping(value = "/generateQuestionSet/{Id}", method = RequestMethod.GET)
    public String createQuestionSet(HttpServletRequest request, @PathVariable long Id) {
        //Admin define value
        int questionLimit = 1;
        List<Question> questionList = questionService.getQuestionsByQuestionId(Id, questionLimit); //TODO

        QuestionSet questionSet = new QuestionSet(questionList);
        long questionSetId = questionSetService.add(questionSet);
        return "redirect:/questionSet/" + questionSetId;
    }

    @RequestMapping(value = "/questionSet/{Id}", method = RequestMethod.GET)
    public String startExam(Model model, HttpServletRequest request, HttpSession session, @PathVariable long Id) {
        QuestionSet questionSet = questionSetService.get(Id);

        //save exam for user
        java.util.Date date = new java.util.Date();
        Timestamp currentTimestamp = new Timestamp(date.getTime());
        //get user object from session
        User user = (User) session.getAttribute("user");
        UserExam userExam = null;
        List<Question> questionSetQuestions = null;
        if (questionSet != null) {
            userExam = new UserExam(currentTimestamp, user, questionSet);
            userExamService.add(userExam);

            //put list of questions in session
            questionSetQuestions = questionSet.getQuestionslist();
        }
        for (Question qes : questionSetQuestions) {
            System.out.println("Question:" + qes.getSubject());
        }
        model.addAttribute("questionSetQuestions", questionSetQuestions);
        model.addAttribute("questionSet", questionSet);
        model.addAttribute("subject", questionSetQuestions.get(0).getSubject());
        model.addAttribute("userExam", userExam);
        return "listQuestion";
    }

}
