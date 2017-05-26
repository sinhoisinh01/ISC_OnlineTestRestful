//Hai
package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.Option;

public interface IOptionService {

	Option findById(long id);
	
	void saveOption(Option option);
	
	void saveOrUpdateOption(Option option);
	
	void deleteOption(Option option);
	
	List<Option> findAllOptions();
}
