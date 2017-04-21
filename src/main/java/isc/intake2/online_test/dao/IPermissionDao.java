//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.Permission;

public interface IPermissionDao {

	Permission findById(long id);
	
	void savePermission(Permission permission);
	
	void deletePermission(Permission permission);
	
	List<Permission> findAllPermissions();
}
