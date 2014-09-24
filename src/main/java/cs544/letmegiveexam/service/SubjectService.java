/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.service;

import cs544.letmegiveexam.dao.SubjectDao;
import cs544.letmegiveexam.crudfacade.EntityFacade;
import cs544.letmegiveexam.model.Subject;
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
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class SubjectService {

    @Autowired
    SubjectDao subjectDao;

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

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addSubject(Subject subject) {
        subjectDao.addSubject(subject);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Subject> getAll() {
        return subjectDao.getSubjects();
    }

    public List<Subject> getAllSubjects() {
        //return crudfasade.getAll(Subject.class);
        //List<Subject> subjects = crudfasade.getAll(Subject.class);
        List<Subject> subjects = crudfasade.findWithNamedQuery("Subject.findAll");
      //  System.out.println("Subject List:" + subjects.size());
//        for (Subject sub : subjects) {
//            System.out.println("Subject:" + sub.getName() + "  Description:" + sub.getDescription());
//        }
        return subjects;
    }

    public Subject getSubjectByName(String subjectName) {
       // System.out.println("calling service");
        Subject subject = subjectDao.findByName(subjectName);
        if (subject != null) {
            return subject;
        } else {
            subject = new Subject(subjectName, subjectName);
            subjectDao.addSubject(subject);
            return subject;
        }
    }

}
