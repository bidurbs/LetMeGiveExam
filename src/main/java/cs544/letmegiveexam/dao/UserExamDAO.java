/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.dao;

import cs544.letmegiveexam.model.UserExam;
import java.math.BigInteger;
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
public class UserExamDAO {

    @Autowired
    SessionFactory sessionFactory;

    public UserExamDAO() {
    }

    public List<UserExam> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from UserExam").list();
    }

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public UserExamDAO(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void add(UserExam userExam) {
        openSession().persist(userExam);
    }

    public UserExam get(long id) {
        return (UserExam) openSession().get(UserExam.class, id);
    }

    public void update(UserExam userExam) {
        openSession().merge(userExam);
    }

    public void delete(int userExamId) {
        UserExam c = get(userExamId);
        openSession().delete(c);
    }

    public List<UserExam> getUserExam(long userId) {
        Query q = sessionFactory.getCurrentSession().createQuery("from UserExam ue where ue.user.id=: id");
        q.setParameter("id", userId);
        return (List<UserExam>) q.list();
    }

}
