/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.service;

import cs544.letmegiveexam.dao.UserExamDAO;
import cs544.letmegiveexam.model.UserExam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Arjun
 */
@Service
public class UserExamService {

    @Autowired
    UserExamDAO userExamDAO;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add(UserExam userExam) {
        userExamDAO.add(userExam);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserExam get(long Id) {
        return userExamDAO.get(Id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(UserExam userExam) {
        userExamDAO.update(userExam);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public List<UserExam> getUserExam(long userId) {
        return userExamDAO.getUserExam(userId);
    }
}
