/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.service;

import cs544.letmegiveexam.dao.QuestionSetDAO;
import cs544.letmegiveexam.model.QuestionSet;
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
public class QuestionSetService {

    @Autowired
    QuestionSetDAO questionSetDAO;
    
    @Transactional(propagation = Propagation.REQUIRED)
    public List<QuestionSet> getAll() {
        return questionSetDAO.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public long add(QuestionSet questionSet) {
        return questionSetDAO.add(questionSet);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public QuestionSet get(long Id) {
        return questionSetDAO.get(Id);
    }

}
