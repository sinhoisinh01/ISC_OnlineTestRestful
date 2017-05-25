//Hai
package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.AnswearType;

public interface IAnswearTypeService {

	AnswearType findById(long id);
	
	List<AnswearType> findAllAnswearTypes();
}
