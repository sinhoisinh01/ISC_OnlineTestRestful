//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.Subject;

public interface ISubjectDao {

	Subject findById(long id);
	
	Subject findBySubName(String name);
	
	Subject findBySubId(String subId);
	
	void saveSubject(Subject subject);
	
	void deleteSubject(Subject subject);
	
	List<Subject> findAllSubjects();

}
