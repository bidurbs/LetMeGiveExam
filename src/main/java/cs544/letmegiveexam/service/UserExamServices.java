/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.EntityFacade;
import cs544.letmegiveexam.model.UserExam;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Arjun
 */
public class UserExamServices {
    @Autowired
    private EntityFacade crudfasade;
    
    public void updateUserExam(UserExam userExam) {
        crudfasade.update(userExam);
    }
 
    public UserExam getUserExamById(Long Id) {
        return (UserExam) crudfasade.read(Id, UserExam.class);
    }

    public void deleteUserExam(UserExam userExam) {
        crudfasade.delete(userExam);        
    }

	public void saveUserExam(UserExam userExam) {
        crudfasade.save(userExam);
    }
}
