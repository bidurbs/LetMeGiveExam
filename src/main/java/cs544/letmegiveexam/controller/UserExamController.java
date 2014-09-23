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
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "/populateResult/{id}", method = RequestMethod.POST)
    public String sumbitExam(@Valid QuestionSet questionSet, BindingResult result, HttpSession session, @PathVariable int id) {

        if (!result.hasErrors()) {
            java.util.Date date = new java.util.Date();
            Timestamp currentTimestamp = new Timestamp(date.getTime());
            User user = (User) session.getAttribute("user");
            QuestionSet questionSetDB = questionSetService.get(id);

            for (int i = 0; i < questionSetDB.getQuestionslist().size(); i++) {
                Question que = questionSetDB.getQuestionslist().get(i);
                que.setUserAnswer(questionSet.getQuestionslist().get(i).getUserAnswer());
            }
            System.out.println("User Id:" + user.getId());
            // QuestionSet questionSetObj = (QuestionSet) session.getAttribute("questionSet");
            UserExam userExam = new UserExam(currentTimestamp, user, questionSetDB);
//        // List<Question> questionSetQuestions = null;
//        if (questionSet != null) {
//            userExam = new UserExam(currentTimestamp, user, questionSet);
            userExamService.add(userExam);
//
//            //put list of questions in session
//            // questionSetQuestions = userExam.getQuestionSet().getQuestionslist();
//        }

            //calculate the currect answers
            List<Question> questionList = questionSetDB.getQuestionslist();
            int score = calcualteResult(questionList);
            System.out.println("Score:" + score);
            userExam.setScore(score);
            userExam.setDuration("5");//currentTimestamp,userExam.getStartTime()); // minutes
            userExamService.update(userExam);
        }
        return "redirect:/examHistory";
    }

    private int calcualteResult(List<Question> questionLIst) {
        int result = 0;
        for (Question question : questionLIst) {
            System.out.println("QuesId:+" + question.getId() + " ,UserAnswer:" + question.getUserAnswer() + " Correct Answer:" + question.getCorrectAnswer());
            if (question.getUserAnswer().equalsIgnoreCase(question.getCorrectAnswer())) {
                result++;
            }
        }
        return result;
    }

    @RequestMapping(value = "/examHistory", method = RequestMethod.GET)
    public String examHistory(Model model, HttpSession session) {
        //long userId = 1L;
        User user = (User) session.getAttribute("user");
        // QuestionSet questionSetDB = questionSetService.get(user.getId());
        List<UserExam> userExamList = userExamService.getUserExam(user.getId());
        System.out.println("userExamList size:" + (userExamList != null ? userExamList.size() : "Null"));
        model.addAttribute("userExamList", userExamList);
        return "examHistory";
    }

}
