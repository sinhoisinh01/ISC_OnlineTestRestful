//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.Part;
import isc.intake2.online_test.entities.Subject;

@Repository("partDao")
public class PartDaoImpl extends AbstractDaoImpl<Long, Part> implements IPartDao{

	public Part findById(long id){
		return getByKey(id);
	}
	
	public Part findByName(String name){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("parName", name));
        return (Part) criteria.uniqueResult();
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
	public List<Part> findAllParts(long subjectId){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.sqlRestriction("{alias}.subject_id = " + subjectId));
		return (List<Part>) criteria.list();
	}
	
	public Boolean isPartExist(Part part){
		return findByName(part.getParName()) != null;
	}

	@SuppressWarnings("unchecked")
	public List<Part> findAllPartforQ() {
		Criteria criteria = createEntityCriteria();	
		return (List<Part>) criteria.list();
	}
}
