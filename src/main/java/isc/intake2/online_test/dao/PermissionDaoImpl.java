//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.Permission;
@Repository("permissionDao")
public class PermissionDaoImpl extends AbstractDaoImpl<Long, Permission> implements IPermissionDao{

	public Permission findById(long id){
		return getByKey(id);
	}
	
	public void savePermission(Permission permission){
		persist(permission);
	}
	
	public void saveOrUpdatePermission(Permission permission){
		saveOrUpdate(permission);
	}
	
	public void deletePermission(Permission permission){
		delete(permission);
	}
	
	@SuppressWarnings("unchecked")
	public List<Permission> findAllPermissions(){
		Criteria criteria = createEntityCriteria();
		return (List<Permission>) criteria.list();
	}
}
