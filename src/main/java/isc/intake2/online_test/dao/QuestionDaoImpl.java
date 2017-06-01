package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.Part;
import isc.intake2.online_test.entities.Question;

@Repository("questionDao")
public class QuestionDaoImpl extends AbstractDaoImpl<Long, Question> implements IQuestionDao {
	
	
	public Question findById(long id){
		return getByKey(id);
	}
	
	public void saveQuestion(Question question){
		persist(question);
	}
	
	public void saveOrUpdateQuestion(Question question){
		saveOrUpdate(question);
	}
	
	public void deleteQuestion(Question question){
		delete(question);
	}
	
	public List<Question> findAllQuestion(){
		Criteria criteria = createEntityCriteria();
		return (List<Question>) criteria.list();
	}

	@Override
	public List<Question> findAllQuestionByPart(long part_id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.sqlRestriction("{alias}.question_part_id = " + part_id));
		return (List<Question>) criteria.list();
	}


	/*
	
	
	void deleteQuestion(Question question);
	
	List<Question> findAllQuestion();*/
	
}
