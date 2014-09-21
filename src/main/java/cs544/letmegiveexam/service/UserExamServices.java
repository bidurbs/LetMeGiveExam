/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.CRUDEntityFacade;
import cs544.letmegiveexam.crudfacade.EntityFacade;
import cs544.letmegiveexam.model.Question;
import cs544.letmegiveexam.model.UserExam;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Arjun
 */
public class UserExamServices {
    @Autowired
    private EntityFacade cRUDEntityFacade;
    
    public void updateUserExam(UserExam userExam) {
        cRUDEntityFacade.update(userExam);
    }
 
    public UserExam getUserExamById(Long Id) {
        return (UserExam) cRUDEntityFacade.read(Id, UserExam.class);
    }

    public void deleteUserExam(UserExam userExam) {
        cRUDEntityFacade.delete(userExam);        
    }

	public void saveUserExam(UserExam userExam) {
        cRUDEntityFacade.save(userExam);
    }
}
