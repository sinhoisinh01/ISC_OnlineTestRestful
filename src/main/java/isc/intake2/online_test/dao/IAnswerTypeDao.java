package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.*;

public interface IAnswerTypeDao {
	AnswerType findById(long id);
	
	List<AnswerType> findAllAnswerType();
}
