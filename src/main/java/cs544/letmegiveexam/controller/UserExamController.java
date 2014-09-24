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
import cs544.letmegiveexam.service.QuestionSetService;
import cs544.letmegiveexam.service.UserExamService;
import cs544.letmegiveexam.util.ExamDuration;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    @Autowired
    QuestionSetService questionSetService;

    @RequestMapping(value = "/populateResult/{Id}/{setId}", method = RequestMethod.POST)
    public String sumbitExam(@Valid QuestionSet questionSet, BindingResult result, HttpSession session, @PathVariable long Id, @PathVariable long setId) {
        UserExam userExam = userExamService.get(Id);
        if (!result.hasErrors()) {

            QuestionSet questionSetDB = questionSetService.get(setId);
            List<Question> questionList = questionSetDB.getQuestionslist();
            for (int i = 0; i < questionList.size(); i++) {
                Question que = questionList.get(i);
                que.setUserAnswer(questionSet.getQuestionslist().get(i).getUserAnswer());
            }

            int score = calcualteResult(questionList);
            //System.out.println("Score:" + score);
            userExam.setScore(score);
            
            //calculate the duration of exam
            //Timestamp ts_now = new Timestamp(());
            long durat = (Long) ExamDuration.get(userExam.getStartTime());
            userExam.setDuration(Long.toString(durat));
            userExamService.update(userExam);
        } else {
            System.out.println("i m here" + result.getFieldError());
        }
        return "redirect:/examHistory";
    }

    private int calcualteResult(List<Question> questionLIst) {
        int result = 0;
        for (Question question : questionLIst) {
           // System.out.println("QuesId:+" + question.getId() + " ,UserAnswer:" + question.getUserAnswer() + " Correct Answer:" + question.getCorrectAnswer());
            if (question.getUserAnswer().equalsIgnoreCase(question.getCorrectAnswer())) {
                result++;
            }
        }
        return result;
    }

    @RequestMapping(value = "/examHistory", method = RequestMethod.GET)
    public String examHistory(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        List<UserExam> userExamList = userExamService.getUserExam(user.getId());
        //System.out.println("userExamList size:" + (userExamList != null ? userExamList.size() : "Null"));
        model.addAttribute("userExamList", userExamList);
        return "examHistory";
    }

}
