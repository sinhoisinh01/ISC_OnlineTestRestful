//Hong
package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.dao.ISubjectDao;
import isc.intake2.online_test.entities.Subject;

@Service("subjectService")
@Transactional
public class SubjectServiceImpl implements ISubjectService{
	
	@Autowired
	private ISubjectDao subjectDao;
	
	public Subject findById(long id){
		return subjectDao.findById(id);
	}

	public void saveSubject(Subject subject){
		subjectDao.saveSubject(subject);
	}
	
	public void updateSubject(Subject subject){
		subjectDao.saveSubject(subject);
	}
	
	public void deleteSubject(Subject subject){
		subjectDao.deleteSubject(subject);
	}
	
	public List<Subject> findAllSubjects(){
		return subjectDao.findAllSubjects();
	}
	
	public boolean isSubjectExist(Subject subject){
		return subjectDao.isSubjectExist(subject);
	}
}
