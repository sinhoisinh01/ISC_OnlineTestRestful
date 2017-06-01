//Hai
package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.AnswerType;

public interface IAnswerTypeService {

	AnswerType findById(long id);
	
	List<AnswerType> findAllAnswerTypes();
}
