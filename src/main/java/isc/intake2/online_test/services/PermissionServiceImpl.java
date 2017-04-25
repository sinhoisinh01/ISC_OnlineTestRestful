//Hong
package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.dao.IPermissionDao;
import isc.intake2.online_test.entities.Permission;

@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements IPermissionService{

	@Autowired
	private IPermissionDao permissionDao;
	
	public Permission findById(long id){
		return permissionDao.findById(id);
	}

	public void savePermission(Permission permission){
		permissionDao.savePermission(permission);
	}
	
	public void saveOrUpdatePermission(Permission permission){
		permissionDao.saveOrUpdatePermission(permission);
	}
	
	public void deletePermission(Permission permission){
		permissionDao.deletePermission(permission);
	}
	
	public List<Permission> findAllPermissions(){
		return permissionDao.findAllPermissions();
	}
}
