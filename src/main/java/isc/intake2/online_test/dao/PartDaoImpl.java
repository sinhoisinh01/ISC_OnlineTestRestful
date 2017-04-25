//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.Part;

@Repository("partDao")
public class PartDaoImpl extends AbstractDaoImpl<Long, Part> implements IPartDao{

	public Part findById(long id){
		return getByKey(id);
	}
	
	public Part findByName(String name){
		return findByName(name);
	}
	
	public void savePart(Part part){
		persist(part);
	}
	
	public void saveOrUpdatePart(Part part){
		saveOrUpdate(part);
	}
	
	public void deletePart(Part part){
		delete(part);
	}
	
	@SuppressWarnings("unchecked")
	public List<Part> findAllParts(){
		Criteria criteria = createEntityCriteria();
		return (List<Part>) criteria.list();
	}
}
