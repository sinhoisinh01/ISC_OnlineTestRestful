//Hong
package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.entities.RelativePrivilege;

@Service("relativePrivilegeService")
@Transactional
public class RelativePrivilegeServiceImpl implements IRelativePrivilegeService{

	@Autowired
	private IRelativePrivilegeService relativePrivilegeService;
	
	public RelativePrivilege findById(long id){
		return relativePrivilegeService.findById(id);
	}
	
	public void saveRelativePrevilege(RelativePrivilege relativePrivilege){
		relativePrivilegeService.saveRelativePrevilege(relativePrivilege);
	}
	
	public void updateRelativePrevilege(RelativePrivilege relativePrivilege){
		relativePrivilegeService.saveRelativePrevilege(relativePrivilege);
	}
	
	public void deleteRelativePrevilege(RelativePrivilege relativePrivilege){
		relativePrivilegeService.deleteRelativePrevilege(relativePrivilege);
	}
	
	public List<RelativePrivilege> findAllRelativePrivileges(){
		return relativePrivilegeService.findAllRelativePrivileges();
	}
}
