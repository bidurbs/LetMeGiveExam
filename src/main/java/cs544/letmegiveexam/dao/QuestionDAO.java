/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.dao;

import cs544.letmegiveexam.model.Question;
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
public class QuestionDAO {

    @Autowired
    SessionFactory sessionFactory;

    public QuestionDAO() {
    }

    public List<Question> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Question").list();
    }

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public QuestionDAO(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void add(Question question) {
        openSession().persist(question);
    }

    public Question get(int id) {
        return (Question) openSession().get(Question.class, id);
    }

    public void update(int questionId, Question question) {
        openSession().merge(question);
    }

    public void delete(int questionId) {
        Question c = get(questionId);
        openSession().delete(c);
    }

}
