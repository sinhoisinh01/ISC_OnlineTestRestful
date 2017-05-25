package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.Question;

public interface IQuestionDao {
	Question findById(long id);
	
	void saveQuestion(Question question);
	
	void saveOrUpdateQuestion(Question question);
	
	void deleteQuestion(Question question);
	
	List<Question> findAllQuestion();
}
