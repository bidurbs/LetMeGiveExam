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

/**
 *
 * @author bidur
 */
public class QuestionSetDAO {
    
     private SessionFactory sessionFactory;
   
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
        Query q = openSession().createQuery("select c from QuestionSet");
        return q.list();
    }
    
    public void add(QuestionSet questionSet) {
          openSession().persist(questionSet);
    }

    public QuestionSet get(int id) {
        return (QuestionSet) openSession().get(QuestionSet.class, id);
    }
   public void update(int questionSetId, QuestionSet questionSet) { 
        openSession().merge(questionSet);       
    }

    public void delete(int questionSetId) {
        QuestionSet c = get(questionSetId);
        openSession().delete(c);
    } 
    
}
