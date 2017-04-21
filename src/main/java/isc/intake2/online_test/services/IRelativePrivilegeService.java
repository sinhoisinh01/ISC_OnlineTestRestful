//Hong
package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.RelativePrivilege;

public interface IRelativePrivilegeService {

	RelativePrivilege findById(long id);
	
	void saveRelativePrevilege(RelativePrivilege relativePrivilege);
	
	void updateRelativePrevilege(RelativePrivilege relativePrivilege);
	
	void deleteRelativePrevilege(RelativePrivilege relativePrivilege);
	
	List<RelativePrivilege> findAllRelativePrivileges();
}
