package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.AnswearType;

@Repository("answearTypeDao")
public class AnswearTypeDaoImpl extends AbstractDaoImpl<Long, AnswearType> implements IAnswearTypeDao {
	
	
	public AnswearType findById(long id){
		return getByKey(id);
	}	
	
	public List<AnswearType> findAllAnswearType(){
		Criteria criteria = createEntityCriteria();
		return (List<AnswearType>) criteria.list();
	}
	
}
