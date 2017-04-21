//Hong
package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.Privilege;

public interface IPrivilegeService {

	Privilege findById(long id);
	
	void savePrivilege(Privilege privilege);
	
	void updatePrivilege(Privilege privilege);
	
	void deletePrivilege(Privilege privilege);
	
	List<Privilege> findAllPrivileges();
}
