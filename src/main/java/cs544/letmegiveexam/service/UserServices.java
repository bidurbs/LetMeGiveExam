/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.CRUDEntityFacade;
import cs544.letmegiveexam.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Arjun
 */
@Service
@Transactional
public class UserServices {
    @Autowired
    private CRUDEntityFacade crudfasade;
    
    public void updateUser(User user) {
        crudfasade.update(user);
    }
 
    public User getUserById(Long Id) {
        return (User) crudfasade.read(Id, User.class);
    }

    public void deleteUser(User user) {
        crudfasade.delete(user);        
    }

	public void saveQuestion(User user) {
        crudfasade.save(user);
    }
        public void createUser(User user){
           User u= (User) crudfasade.create(user);
            System.out.println("generated user Id " + u.getId());
           //crudfasade.createAuthority(u);
                     
            System.out.println(u.getUsername());
        }
}
