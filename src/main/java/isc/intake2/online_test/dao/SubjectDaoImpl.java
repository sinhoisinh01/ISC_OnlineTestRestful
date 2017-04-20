//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.Subject;

@Repository("subjectDao")
public class SubjectDaoImpl extends AbstractDaoImpl<Long, Subject> implements ISubjectDao {

	public Subject findById(long id){
		return getByKey(id);
	}
	
	public void saveSubject(Subject subject){
		persist(subject);
	}
	
	public void deleteSubject(Subject subject){
		deleteSubject(subject);
	}
	
	@SuppressWarnings("unchecked")
	public List<Subject> findAllSubjects(){
		Criteria criteria = createEntityCriteria();
		return (List<Subject>) criteria.list();
	}
}
