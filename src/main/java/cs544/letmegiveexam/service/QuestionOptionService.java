/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.CRUDEntityFacade;
import cs544.letmegiveexam.model.Question;
import cs544.letmegiveexam.model.QuestionOption;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Arjun
 */
public class QuestionOptionService {
    @Autowired
    private CRUDEntityFacade cRUDEntityFacade;
    
    public void updateQuestionOption(QuestionOption questionOption) {
        cRUDEntityFacade.update(questionOption);
    }
 
    public QuestionOption getQuestionOptionById(Long Id) {
        return (QuestionOption) cRUDEntityFacade.read(Id, QuestionOption.class);
    }

    public void deleteQuestionOption(QuestionOption questionOption) {
        cRUDEntityFacade.delete(questionOption);        
    }

	public void saveQuestionOption(QuestionOption questionOption) {
        cRUDEntityFacade.save(questionOption);
    }
}
