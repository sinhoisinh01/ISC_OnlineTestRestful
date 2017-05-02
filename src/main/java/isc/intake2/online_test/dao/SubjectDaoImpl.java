//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.Subject;
import isc.intake2.online_test.entities.User;

@Repository("subjectDao")
public class SubjectDaoImpl extends AbstractDaoImpl<Long, Subject> implements ISubjectDao {
	 
	public Subject findById(long id){
		return getByKey(id);
	}

	public Subject findByName(String name){
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("subName", name));
        return (Subject) criteria.uniqueResult();
	}
	
	public void saveSubject(Subject subject){
		persist(subject);
	}
	
	public void saveOrUpdateSubject(Subject subject){
		saveOrUpdate(subject);
	}
	
	public void deleteSubject(Subject subject){
		delete(subject);
	}
	
	@SuppressWarnings("unchecked")
	public List<Subject> findAllSubjectsParent(){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.sqlRestriction("{alias}.sub_id is null"));
		return (List<Subject>)criteria.list();
	}

	@Override
	public boolean isSubjectExist(Subject subject) {
		return findByName(subject.getSubName()) != null;
	}
	
}
