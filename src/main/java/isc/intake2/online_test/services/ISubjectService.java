//Hong
package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.Subject;

public interface ISubjectService {

	Subject findById(long id);

	void saveSubject(Subject subject);
	
	void saveOrUpdateSubject(Subject subject);
	
	void deleteSubject(Subject subject);
	
	List<Subject> findAllSubjectsParent();
	
	boolean isSubjectExist(Subject subject);
}
