/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.EntityFacade;
import cs544.letmegiveexam.dao.QuestionDAO;
import cs544.letmegiveexam.model.Question;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Arjun
 */
@Service
public class QuestionService {
    
    @Autowired
    private EntityFacade crudfasade;
    
    @Autowired
    QuestionDAO questionDAO;
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateQuestion(Question question) {
        crudfasade.update(question);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Question getQuestionById(Long Id) {
        return (Question) crudfasade.read(Id, Question.class);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteQuestion(Question question) {
        crudfasade.delete(question);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveQuestion(Question question) {
        crudfasade.save(question);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Question> getAll() {
        return questionDAO.getAll();
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addQuestion(Question question) {
        questionDAO.add(question);
    }
     
    
    @Transactional
    public List<Question> getQuestionsByQuestionId(long Id) {
        System.out.println("**********1**********");
        try {
            Map<String, Long> paramaters = new HashMap<>(1);
            //paramaters.put("questionId", Id);
            int resultLimit = 10;
            System.out.println("**********2**********");
            List<Question> qans = crudfasade.findWithNamedQuery("Question.findAll"); //, paramaters, resultLimit
            return qans; //return only 10 question
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
