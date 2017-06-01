//Hai
package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.dao.IQuestionDao;
import isc.intake2.online_test.entities.Question;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements IQuestionService{

	@Autowired
	private IQuestionDao questionDao;
	
	public Question findById(long id){
		return questionDao.findById(id);
	}

	public void saveQuestion(Question question){
		questionDao.saveQuestion(question);
	}
	
	public void saveOrUpdateQuestion(Question question){
		questionDao.saveOrUpdateQuestion(question);
	}
	
	public void deleteQuestion(Question question){
		questionDao.deleteQuestion(question);
	}
	
	public List<Question> findAllQuestions(){
		return questionDao.findAllQuestion();
	}
	
	public List<Question> findAllQuestionsByPartId(long part_id){
		return questionDao.findAllQuestionByPart(part_id);
	}
}
