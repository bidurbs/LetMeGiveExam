/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.controller;

import cs544.letmegiveexam.util.EmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

/**
 *
 * @author bidur
 */
@Controller("sendmail")
public class SendMailController {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendMail() {
        try {
            EmailManager.sendEmail(mailSender, "Registration Information", "You are successfully registered", "bidurbs@gmail.com");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
