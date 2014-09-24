/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.aspect;

import cs544.letmegiveexam.model.QuestionSet;
import cs544.letmegiveexam.model.User;
import cs544.letmegiveexam.model.UserExam;
import cs544.letmegiveexam.service.UserExamService;
import cs544.letmegiveexam.util.EmailManager;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 *
 * @author nirali_bheda
 */
@Aspect
@Component
public class EmailAspect implements IEmailAspect{
    
     @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    EmailManager emailManager;
    
     @Autowired
    UserExamService userExamService;
    
    @After("execution (* cs544.letmegiveexam.service.UserServices.createUser(..)) && args(user)")
    public void emailTraceMethod(JoinPoint point, User user){
        System.out.println("After trace method.. "+user.getFirstName());
        String subject = "Congratulations, You are successfully enrolled in LetMeGiveExam. ";
        subject = subject + "\n Here are your Username And password";
        subject = subject + "\n Username: " + user.getUsername() + " ,";
          subject = subject + "\n Password : " + user.getPassword();
        emailManager.sendEmail(mailSender, "Registered to LetMeGiveExam", subject, user.getEmail());
       
    }
     @After("execution (* cs544.letmegiveexam.controller.UserExamController.sumbitExam(..))&& args(questionSet,result,session,Id,setId) ")
    public void logUserExam(JoinPoint point, QuestionSet questionSet, BindingResult result, HttpSession session, long Id, long setId) {
        UserExam userExam = userExamService.get(Id);
        User user = (User) session.getAttribute("user");
        String subject="Here is the result for your Exam give on LetMeGiveExam";
         subject = subject + "\n Subject: "+ userExam.getQuestionSet().getQuestionslist().get(0).getSubject().getName();
         subject = subject + "\n Score: "+ userExam.getScore();
         subject = subject + "\n Duration: "+ userExam.getDuration();
         emailManager.sendEmail(mailSender, "LetMeGiveExam Score Card", subject, user.getEmail());
    }
}