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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Arjun
 */
public class QuestionSetService {

    @Autowired
    private EntityFacade crudfasade;

    public void updateQuestionSet(QuestionSet questionSet) {
        crudfasade.update(questionSet);
    }

    public QuestionSet getQuestionSetById(Long Id) {
        return (QuestionSet) crudfasade.read(Id, QuestionSet.class);
    }

    public void deleteQuestionSet(QuestionSet questionSet) {
        crudfasade.delete(questionSet);
    }

    public QuestionSet saveQuestionSet(QuestionSet questionSet) {
       return (QuestionSet) crudfasade.create(questionSet);
    }

    public void createQuestionSet(List<Question> questionSet) {
    }

}
