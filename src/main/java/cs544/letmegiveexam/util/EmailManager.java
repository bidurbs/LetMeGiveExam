/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.util;

import javax.inject.Singleton;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 *
 * @author bidur
 * @version 0.0.1
 */
@Component
@Singleton
public class EmailManager {

    /**
     * This method will send email 
     *
     * @param mailSender Java email sender
     * @param subject Email subject
     * @param body Email body
     * @param mailTo Mail to information
     */
    public static void sendEmail(JavaMailSender mailSender, String subject, String body, String mailTo) {

        SimpleMailMessage email = new SimpleMailMessage();
        
        email.setText(body);
        email.setTo(mailTo);
        email.setSubject(subject);
        mailSender.send(email);
    }

}
