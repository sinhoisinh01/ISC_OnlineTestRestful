package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.AnswerType;

@Repository("answerTypeDao")
public class AnswerTypeDaoImpl extends AbstractDaoImpl<Long, AnswerType> implements IAnswerTypeDao {
	
	
	public AnswerType findById(long id){
		return getByKey(id);
	}	
	
	@Override
	public List<AnswerType> findAllAnswerType(){
		Criteria criteria = createEntityCriteria();
		return (List<AnswerType>) criteria.list();
	}
}
