/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.CRUDEntityFacade;
import cs544.letmegiveexam.crudfacade.EntityFacade;
import cs544.letmegiveexam.model.Question;
import cs544.letmegiveexam.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Arjun
 */
public class UserServices {
    @Autowired
    private EntityFacade cRUDEntityFacade;
    
    public void updateUser(User user) {
        cRUDEntityFacade.update(user);
    }
 
    public User getUserById(Long Id) {
        return (User) cRUDEntityFacade.read(Id, User.class);
    }

    public void deleteUser(User user) {
        cRUDEntityFacade.delete(user);        
    }

	public void saveQuestion(User user) {
        cRUDEntityFacade.save(user);
    }
}
