/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.dao.UserDAO;
import cs544.letmegiveexam.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bidur
 */
@Service
public class UserService {
    
    @Autowired
    UserDAO userDAO;
    
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(long userId, User user) {
        userDAO.update(userId, user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User getUserById(Long Id) {
        return (User) userDAO.get(Id);
    }

    

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveUser(User user) {
        userDAO.add(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addUser(User user) {
        userDAO.add(user);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}
