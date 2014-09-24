/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.letmegiveexam.dao;

import cs544.letmegiveexam.model.Setting;
import org.hibernate.Session;
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
@Transactional(propagation = Propagation.MANDATORY)
public class SettingDao {

    public SettingDao() {
    }
    @Autowired
    SessionFactory sessionFactory;
    
    public Session openSession(){
        return sessionFactory.getCurrentSession();
    }
   
    public void update(Setting setting) {
        openSession().merge(setting);
    }
    public Setting get(long id) {
        return (Setting) openSession().get(Setting.class, id);
    }
}
