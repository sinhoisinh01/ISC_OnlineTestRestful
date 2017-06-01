//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.Part;

public interface IPartDao {

	
	
	Part findById(long id);
	
	Part findByName(String name);
	
	void savePart(Part part);
	
	void saveOrUpdatePart(Part part);
	
	void deletePart(Part part);
	
	List<Part> findAllParts(long subjectId);
	
	List<Part> findAllPartforQ();

	Boolean isPartExist(Part part);

}
