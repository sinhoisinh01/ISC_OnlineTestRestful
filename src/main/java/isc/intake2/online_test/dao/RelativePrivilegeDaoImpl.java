//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.RelativePrivilege;
@Repository("relativePrivilegeDao")
public class RelativePrivilegeDaoImpl extends AbstractDaoImpl<Long, RelativePrivilege> implements IRelativePrivilegeDao{

	public RelativePrivilege findById(long id){
		return getByKey(id);
	}
	
	public void saveRelativePrevilege(RelativePrivilege relativePrivilege){
		persist(relativePrivilege);
	}
	
	public void deleteRelativePrevilege(RelativePrivilege relativePrivilege){
		delete(relativePrivilege);
	}
	
	@SuppressWarnings("unchecked")
	public List<RelativePrivilege> findAllRelativePrivileges(){
		Criteria criteria = createEntityCriteria();
		return (List<RelativePrivilege>) criteria.list();
	}
}
