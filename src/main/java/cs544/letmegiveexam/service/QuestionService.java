/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.CRUDEntityFacade;
import cs544.letmegiveexam.model.Question;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Arjun
 */
public class QuestionService {
    @Autowired
    private CRUDEntityFacade cRUDEntityFacade;
    
    public void updateQuestion(Question question) {
        cRUDEntityFacade.update(question);
    }
 
    public Question getQuestionById(Long Id) {
        return (Question) cRUDEntityFacade.read(Id, Question.class);
    }

    public void deleteQuestion(Question question) {
        cRUDEntityFacade.delete(question);        
    }

	public void saveQuestion(Question question) {
        cRUDEntityFacade.save(question);
    }
}
