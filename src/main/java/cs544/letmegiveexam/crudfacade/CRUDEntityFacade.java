
package cs544.letmegiveexam.crudfacade;

import cs544.letmegiveexam.model.User;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

/**
 *
 * @author bidur
 * @version 0.0.1
 */


public class CRUDEntityFacade<T> implements EntityFacade<T> {

    public Class entityClass;

    //@Autowired
    private SessionFactory sessionFactory;

    private boolean operationSuccessful;

    
    /**
     *
     * @param entity
     * @return
     * @throws EntityExistsException
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws TransactionRequiredException
     */
    @Override
    public T create(T entity) throws EntityExistsException,
            IllegalStateException, IllegalArgumentException,
            TransactionRequiredException {
        sessionFactory.getCurrentSession().save(entity);
        
        System.out.println("Saved.. ");
        return entity;
    }
    @Override
    public T createAuthority(T entity){
        User user=(User) entity;
        System.out.println(user.getId());
        String sql="insert into authority(user_id,username,authority) values(?,?,?)";
        SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
        createSQLQuery.setParameter(0, user.getId());
        createSQLQuery.setParameter(1, user.getUsername());
        createSQLQuery.setParameter(2, "ROLE_USER");
         createSQLQuery.executeUpdate();
         
        return entity;
        
    }
    @Override
    public User findByUsername(String username){
        String sql="FROM User u WHERE u.username= :username";
        Query query=sessionFactory.getCurrentSession().createQuery(sql);
        query.setParameter("username", username);
        
       List<User> user=query.list();
        
        return user.get(0);
    }
    /**
     *
     * @param primaryKey
     * @return
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     */
    @Override
    public T read(final Serializable primaryKey, Class c) throws IllegalStateException,
            IllegalArgumentException {
        return (T) sessionFactory.getCurrentSession().get(c, primaryKey);
    }
    

    /**
     *
     * @param entity
     * @return
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws TransactionRequiredException
     */
    @Override
    public boolean update(final T entity) throws IllegalStateException,
            IllegalArgumentException, TransactionRequiredException {
        try {
            sessionFactory.getCurrentSession().update(entity);
            operationSuccessful = true;
        } catch (Exception ex) {

        }
        return operationSuccessful;
    }

    /**
     *
     * @param entity
     * @return
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws TransactionRequiredException
     * @throws PersistenceException
     */
    @Override
    public boolean delete(final T entity) throws IllegalStateException,
            IllegalArgumentException, TransactionRequiredException,
            PersistenceException {
        try {
            sessionFactory.getCurrentSession().delete(entity);
            operationSuccessful = true;
        } catch (Exception ex) {

        }
        return operationSuccessful;

    }

    /**
     *named query without parameter 
     * @param queryName
     * @return
     */
    @Override   
    public List findWithNamedQuery(String queryName) {
        return sessionFactory.getCurrentSession().getNamedQuery(queryName).list();
    }
    
    /**
     * named query with limited number of results 
     * @param queryName
     * @param resultLimit
     * @return 
     */

    @Override
    public List findWithNamedQuery(String queryName, int resultLimit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * named query with parameters 
     * @param namedQueryName
     * @param parameters
     * @return 
     */
    @Override
    public List findWithNamedQuery(String namedQueryName, Map<String, String> parameters) {
        //  Set parameters = parameters.entrySet();
        Query query = sessionFactory.openSession().getNamedQuery(namedQueryName);

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.list();
    }

    /**
     * named query with parameters and limited number of results
     * @param namedQueryName
     * @param parameters
     * @param resultLimit
     * @return 
     */
    @Override
    public List findWithNamedQuery(String namedQueryName, Map<String, String> parameters, int resultLimit) {
        Query query = sessionFactory.openSession().getNamedQuery(namedQueryName);

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.list().subList(0, resultLimit - 1);
    }

    @Override
    public T save(T entity) throws EntityExistsException, IllegalStateException, IllegalArgumentException, TransactionRequiredException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T merge(T entity) throws IllegalStateException, IllegalArgumentException, TransactionRequiredException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findWithNativeQuery(String queryName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findWithNamedQuery(String namedQueryName, Map<String, String> parameters, Map<String, Long> parameters2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List getAll(T entity) {
        return sessionFactory.getCurrentSession().createCriteria(entity.getClass()).list();
    }
    
    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setOperationSuccessful(boolean operationSuccessful) {
        this.operationSuccessful = operationSuccessful;
    }

      
}
