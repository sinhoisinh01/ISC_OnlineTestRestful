//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.ExamTaker;

public interface IExamTakerDao {

	ExamTaker findById(long id);
	
	ExamTaker findByName(String name);
	
	void saveExamTaker(ExamTaker examTaker);
	
	void deleteExamTaker(ExamTaker examTaker);
	
	List<ExamTaker> findAllExamTakers();
}
