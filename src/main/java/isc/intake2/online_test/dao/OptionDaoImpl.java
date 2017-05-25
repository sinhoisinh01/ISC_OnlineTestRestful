package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.Option;
import isc.intake2.online_test.entities.Question;

@Repository("optionDao")
public class OptionDaoImpl extends AbstractDaoImpl<Long, Option> implements IOptionDao {
	
	
	public Option findById(long id){
		return getByKey(id);
	}
	
	public void saveOption(Option option){
		persist(option);
	}
	
	public void saveOrUpdateOption(Option option){
		saveOrUpdate(option);
	}
	
	public void deleteOption(Option option){
		delete(option);
	}
	
	public List<Option> findAllOption(){
		Criteria criteria = createEntityCriteria();
		return (List<Option>) criteria.list();
	}
	
}
