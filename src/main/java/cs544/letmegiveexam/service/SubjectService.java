/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.CRUDEntityFacade;
import cs544.letmegiveexam.crudfacade.EntityFacade;
import cs544.letmegiveexam.model.Question;
import cs544.letmegiveexam.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Arjun
 */
public class SubjectService {
    @Autowired
    private EntityFacade cRUDEntityFacade;
    public void updateSubject(Subject subject) {
        cRUDEntityFacade.update(subject);
    }
 
    public Subject getSubjectById(Long Id) {
        return (Subject) cRUDEntityFacade.read(Id, Subject.class);
    }

    public void deleteSubject(Subject subject) {
        cRUDEntityFacade.delete(subject);        
    }

	public void saveSubject(Subject subject) {
        cRUDEntityFacade.save(subject);
    }
}