//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;

import isc.intake2.online_test.entities.Privilege;

public class PrivilegeDaoImpl extends AbstractDaoImpl<Long, Privilege> implements IPrivilegeDao{

	public Privilege findById(long id){
		return getByKey(id);
	}
	
	public void savePrivilege(Privilege privilege){
		persist(privilege);
	}
	
	public void deletePrivilege(Privilege privilege){
		delete(privilege);
	}
	
	@SuppressWarnings("unchecked")
	public List<Privilege> findAllPrivileges(){
		Criteria criteria = createEntityCriteria();
		return (List<Privilege>) criteria.list();
	}
}
