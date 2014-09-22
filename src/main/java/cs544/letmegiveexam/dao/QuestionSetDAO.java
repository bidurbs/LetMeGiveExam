/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.dao;

import cs544.letmegiveexam.model.QuestionSet;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bidur
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class QuestionSetDAO {

    @Autowired
    SessionFactory sessionFactory;

    public QuestionSetDAO() {
    }

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public QuestionSetDAO(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List<QuestionSet> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from QuestionSet");
        return q.list();
    }

    public long add(QuestionSet questionSet) {
        return (long) openSession().save(questionSet);
    }

    public void update(int questionSetId, QuestionSet questionSet) {
        openSession().merge(questionSet);
    }

    public QuestionSet get(long Id) {
        return (QuestionSet) openSession().get(QuestionSet.class, Id);
    }

}
