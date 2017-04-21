package isc.intake2.online_test.dao;

import java.io.Serializable;
 
import java.lang.reflect.ParameterizedType;
 
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
public abstract class AbstractDaoImpl<PK extends Serializable, T> implements IAbstractDao<PK,T>{
     
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDaoImpl(){
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
    
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    
    @SuppressWarnings("unchecked")
	@Override
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }
 
    @Override
    public void persist(T entity) {
        getSession().persist(entity);
    }
    
    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }
     
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
 
}
