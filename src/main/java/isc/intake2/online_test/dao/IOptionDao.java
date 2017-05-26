package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.Option;

public interface IOptionDao {
	Option findById(long id);
	
	void saveOption(Option option);
	
	void saveOrUpdateOption(Option option);
	
	void deleteOption(Option option);
	
	List<Option> findAllOption();
}
