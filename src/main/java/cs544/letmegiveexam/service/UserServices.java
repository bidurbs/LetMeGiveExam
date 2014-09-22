/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.EntityFacade;
import cs544.letmegiveexam.model.User;
import cs544.letmegiveexam.util.EmailManager;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 *
 * @author Arjun
 */
public class UserServices {
    @Autowired
    private EntityFacade cRUDEntityFacade;
    
    @Autowired
    JavaMailSenderImpl mailSender;
    
        
    
    @Autowired
    EmailManager emailManager;
    
    public void updateUser(User user) {
        cRUDEntityFacade.update(user);
    }
 
    public User getUserById(Long Id) {
        return (User) cRUDEntityFacade.read(Id, User.class);
    }
     public User getUserByUsername(String username) {        
            
        return  cRUDEntityFacade.findByUsername(username);
    }

    public void deleteUser(User user) {
        cRUDEntityFacade.delete(user);        
    }

	public void saveQuestion(User user) {
        cRUDEntityFacade.save(user);
    }
        public void createUser(User user){
           User u= (User) cRUDEntityFacade.create(user);
            System.out.println("generated user Id " + u.getId());
           cRUDEntityFacade.createAuthority(u);
           String subject="Congratulations, You are successfully enrolled in LetMeGiveExam. ";
           subject=subject+ "\n Here are your Username And password";
           subject=subject+ "\n Username: " + u.getUsername() + " , Password : " +u.getPassword();
           emailManager.sendEmail(mailSender, "Registered to LetMeGiveExam", subject, u.getEmail());
            System.out.println(u.getUsername());
        }
}
