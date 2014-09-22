/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.service;

import cs544.letmegiveexam.crudfacade.EntityFacade;
import cs544.letmegiveexam.model.Subject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Arjun
 */
public class SubjectService {

    @Autowired
    private EntityFacade crudfasade;

    public void updateSubject(Subject subject) {
        crudfasade.update(subject);
    }

    public Subject getSubjectById(Long Id) {
        return (Subject) crudfasade.read(Id, Subject.class);
    }

    public void deleteSubject(Subject subject) {
        crudfasade.delete(subject);
    }

    public void saveSubject(Subject subject) {
        crudfasade.save(subject);
    }

    public List<Subject> getAllSubjects() {
        //return crudfasade.getAll(Subject.class);
        //List<Subject> subjects = crudfasade.getAll(Subject.class);
        List<Subject> subjects =crudfasade.findWithNamedQuery("Subject.findAll");
        System.out.println("Subject List:" + subjects.size());
        for (Subject sub : subjects) {
            System.out.println("Subject:" + sub.getName() + "  Description:" + sub.getDescription());
        }
        return subjects;
    }

}
