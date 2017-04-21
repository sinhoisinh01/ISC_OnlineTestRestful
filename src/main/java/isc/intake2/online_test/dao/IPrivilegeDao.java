//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.Privilege;

public interface IPrivilegeDao {

	Privilege findById(long id);
	
	void savePrivilege(Privilege privilege);
	
	void deletePrivilege(Privilege privilege);
	
	List<Privilege> findAllPrivileges();
}
