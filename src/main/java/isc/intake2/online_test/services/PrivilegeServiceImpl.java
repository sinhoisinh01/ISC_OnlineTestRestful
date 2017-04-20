//Hong
package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.dao.IPrivilegeDao;
import isc.intake2.online_test.entities.Privilege;

@Service("privilegeService")
@Transactional
public class PrivilegeServiceImpl implements IPrivilegeService{

	@Autowired
	IPrivilegeDao privilegeDao;
	
	public Privilege findById(long id){
		return privilegeDao.findById(id);
	}
	
	public void savePrivilege(Privilege privilege){
		privilegeDao.savePrivilege(privilege);
	}
	
	public void updatePrivilege(Privilege privilege){
		privilegeDao.savePrivilege(privilege);
	}
	
	public void deletePrivilege(Privilege privilege){
		privilegeDao.deletePrivilege(privilege);
	}
	
	public List<Privilege> findAllPrivileges(){
		return privilegeDao.findAllPrivileges();
	}
}