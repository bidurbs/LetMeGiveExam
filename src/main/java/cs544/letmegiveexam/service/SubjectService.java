/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.service;

import cs544.letmegiveexam.Dao1.SubjectDao;
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

    public void saveSubject(Subject subject) {
        crudfasade.save(subject);
    }
    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public List<Subject> getAll(){
        return subjectDao.getSubjects();
    }
    
}
