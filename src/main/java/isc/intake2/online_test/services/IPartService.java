package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.Part;

public interface IPartService {

	Part findById(long id);
	
	Part findByName(String name);
	
	void savePart(Part part);
	
	void saveOrUpdate(Part part);
	
	void deletePart(Part part);
	
	List<Part> findAllPart(long subjectId);
	
	List<Part> findAllPartforQ();
	
	Boolean isPartExist(Part part);
}
