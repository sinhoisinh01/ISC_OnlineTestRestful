package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.*;

public interface IAnswearTypeDao {
	AnswearType findById(long id);
	
	List<AnswearType> findAllAnswearType();
}
