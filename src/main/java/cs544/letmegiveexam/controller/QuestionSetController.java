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
import cs544.letmegiveexam.service.SettingService;
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

    @Autowired
    SettingService settingService;

    @RequestMapping(value = "/generateQuestionSet/{Id}", method = RequestMethod.GET)
    public String createQuestionSet(HttpServletRequest request, @PathVariable long Id) {
        //Admin define value
        int questionLimit = (settingService.getSetting() != null) ? settingService.getSetting().getNoOfQuestions() : 5;
        List<Question> questionList = questionService.getRandomQuestionsBySubjectId(Id, questionLimit); //TODO
        if (questionList.size() >0) {
            QuestionSet questionSet = new QuestionSet(questionList);
            long questionSetId = questionSetService.add(questionSet);
            return "redirect:/questionSet/" + questionSetId;
        } else {
            return "redirect:/welcome?msg=no sufficient questions for this subject.choose other subject";
        }
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

        if (questionSet != null) {
            userExam = new UserExam(currentTimestamp, user, questionSet);
            userExamService.add(userExam);
            model.addAttribute("questionSetQuestions", userExam.getQuestionSet().getQuestionslist());
            //session.setAttribute("questionSet", questionSet);
            model.addAttribute("questionSet", questionSet);
            model.addAttribute("subject", userExam.getQuestionSet().getQuestionslist().get(0).getSubject());
        }
        model.addAttribute("userExam", userExam);
        return "userExam";
    }

}
