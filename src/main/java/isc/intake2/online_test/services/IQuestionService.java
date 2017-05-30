//Hai
package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.Permission;
import isc.intake2.online_test.entities.Question;

public interface IQuestionService {

	Question findById(long id);
	
	void saveQuestion(Question question);
	
	void saveOrUpdateQuestion(Question question);
	
	void deleteQuestion(Question question);
	
	List<Question> findAllQuestions();
}
