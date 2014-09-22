/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.dao;

import cs544.letmegiveexam.model.Subject;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Arjun
 */
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class SubjectDao {
    @Autowired
    SessionFactory sessionFactory;
        
	public List<Subject> getSubjects() {
		return sessionFactory.getCurrentSession().createQuery("from Subject").list();
	}

    public void addSubject(Subject subject) {
        sessionFactory.getCurrentSession().persist(subject);
    }
    
}
