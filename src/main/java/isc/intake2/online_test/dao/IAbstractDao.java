package isc.intake2.online_test.dao;

import java.io.Serializable;

public interface IAbstractDao <PK extends Serializable, T>{

	void persist(T entity);

	void delete(T entity);

	T getByKey(PK key);
	
	void saveOrUpdate(T entity);
}
