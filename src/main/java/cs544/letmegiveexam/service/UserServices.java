/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.CRUDEntityFacade;
import cs544.letmegiveexam.model.User;
import cs544.letmegiveexam.util.EmailManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Arjun
 */
@Service
@Transactional
public class UserServices implements IUserService{

    @Autowired
    private CRUDEntityFacade crudfasade;

    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    EmailManager emailManager;

    public void updateUser(User user) {
        crudfasade.update(user);
    }

    public User getUserById(Long Id) {

        return (User) crudfasade.read(Id, User.class);
    }

    public User getUserByUsername(String username) {

        return crudfasade.findByUsername(username);

    }

    public void deleteUser(User user) {
        crudfasade.delete(user);
    }

    public void saveQuestion(User user) {
        crudfasade.save(user);
    }
    @Override
    public void createUser(User user) {
        User u = (User) crudfasade.create(user);
        System.out.println("generated user Id " + u.getId());
        
           
        crudfasade.createAuthority(u);
//        String subject = "Congratulations, You are successfully enrolled in LetMeGiveExam. ";
//        subject = subject + "\n Here are your Username And password";
//        subject = subject + "\n Username: " + u.getUsername() + " , Password : " + u.getPassword();
//        emailManager.sendEmail(mailSender, "Registered to LetMeGiveExam", subject, u.getEmail());
//       
              
         System.out.println(u.getUsername());
    }
}
