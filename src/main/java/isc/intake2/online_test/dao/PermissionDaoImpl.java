//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;

import isc.intake2.online_test.entities.Permission;

public class PermissionDaoImpl extends AbstractDaoImpl<Long, Permission> implements IPermissionDao{

	public Permission findById(long id){
		return getByKey(id);
	}
	
	public void savePermission(Permission permission){
		persist(permission);
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
