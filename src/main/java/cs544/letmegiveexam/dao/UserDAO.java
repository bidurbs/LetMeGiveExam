/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.letmegiveexam.dao;

import cs544.letmegiveexam.model.User;
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
public class UserDAO {

    @Autowired
    SessionFactory sessionFactory;

    public UserDAO() {
    }

    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public UserDAO(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public void add(User user) {
        openSession().persist(user);
    }

    public User get(long id) {
        return (User) openSession().get(User.class, id);
    }

    public void update(long userId, User user) {
        openSession().merge(user);
    }

    public void delete(int userId) {
        User c = get(userId);
        openSession().delete(c);
    }
    
    public User findByUsername(String username) {
        Query q = sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.username= :username");
        q.setParameter("username", username);
        User u = (User) q.list();
        return u;
    }

}
