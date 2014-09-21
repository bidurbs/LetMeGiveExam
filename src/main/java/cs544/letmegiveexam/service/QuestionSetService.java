/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.CRUDEntityFacade;
import cs544.letmegiveexam.crudfacade.EntityFacade;
import cs544.letmegiveexam.model.Question;
import cs544.letmegiveexam.model.QuestionSet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Arjun
 */
public class QuestionSetService {
    @Autowired
    private EntityFacade cRUDEntityFacade;
    
    public void updateQuestionSet(QuestionSet questionSet) {
        cRUDEntityFacade.update(questionSet);
    }
 
    public QuestionSet getQuestionSetById(Long Id) {
        return (QuestionSet) cRUDEntityFacade.read(Id, QuestionSet.class);
    }

    public void deleteQuestionSet(QuestionSet questionSet) {
        cRUDEntityFacade.delete(questionSet);        
    }

	public void saveQuestionSet(QuestionSet questionSet) {
        cRUDEntityFacade.save(questionSet);
    }
}
