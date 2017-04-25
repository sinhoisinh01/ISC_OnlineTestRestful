//Hong
package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.Permission;

public interface IPermissionService {

	Permission findById(long id);
	
	void savePermission(Permission permission);
	
	void saveOrUpdatePermission(Permission permission);
	
	void deletePermission(Permission permission);
	
	List<Permission> findAllPermissions();
}
