/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.model.Question;
import cs544.letmegiveexam.model.UserExam;
import cs544.letmegiveexam.service.UserExamService;
import java.sql.Timestamp;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @RequestMapping(value = "/populateResult", method = RequestMethod.POST)
    public String sumbitExam(@Valid UserExam userExam, BindingResult result) {
        if (!result.hasErrors()) {
            java.util.Date date = new java.util.Date();
        Timestamp currentTimestamp = new Timestamp(date.getTime());
            //calculate the currect answers
            List<Question> questionList = userExam.getQuestionSet().getQuestionslist();
            int score = calcualteResult(questionList);
             System.out.println("Score:"+score);
            userExam.setScore(score);
            userExam.setDuration("5");//currentTimestamp,userExam.getStartTime()); // minutes
            userExamService.update(userExam);
        }
        return "redirect:/examHistory";
    }
    
    private int calcualteResult(List<Question> questionLIst){
        int result =0;
        for(Question question: questionLIst){
            System.out.println("QuesId:+"+question.getId()+" ,UserAnswer:"+question.getUserAnswer()+" Correct Answer:"+question.getCorrectAnswer());
            if(question.getUserAnswer().equalsIgnoreCase(question.getCorrectAnswer())){
                result ++;
            }
        }
        return result;
    }
    
    @RequestMapping(value = "/examHistory", method = RequestMethod.GET)
    public String examHistory(Model model) {
        long userId = 1L;
        List<UserExam> userExamList = userExamService.getUserExam(userId);
        model.addAttribute("userExamList", userExamList);
        return "examHistory";
    }

}
