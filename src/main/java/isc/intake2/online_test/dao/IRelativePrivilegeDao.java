//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.RelativePrivilege;

public interface IRelativePrivilegeDao {

	RelativePrivilege findById(long id);
	
	void saveRelativePrevilege(RelativePrivilege relativePrivilege);
	
	void deleteRelativePrevilege(RelativePrivilege relativePrivilege);
	
	List<RelativePrivilege> findAllRelativePrivileges();
}
