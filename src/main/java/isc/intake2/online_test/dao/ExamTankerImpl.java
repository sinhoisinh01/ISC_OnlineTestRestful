package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.ExamTaker;

@Repository("examTaker")
public class ExamTankerImpl extends AbstractDaoImpl<Long, ExamTaker> implements IExamTakerDao{

	public ExamTaker findById(long id){
		return getByKey(id);
	}
	
	public ExamTaker findByName(String name){
		return findByName(name);
	}
	
	public void saveExamTaker(ExamTaker examTaker){
		persist(examTaker);
	}
	
	public void deleteExamTaker(ExamTaker examTaker){
		delete(examTaker);
	}
	
	@SuppressWarnings("unchecked")
	public List<ExamTaker> findAllExamTakers(){
		Criteria criteria = createEntityCriteria();
		return (List<ExamTaker>) criteria.list();
	}
}
