package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.UserType;

public interface IUserTypeService {
	UserType findById(Long id);
	
	UserType findByName(String name);
	
	void saveUserType(UserType userType);
	
	void saveOrUpdateType(UserType userType);
	
	void deleteUserType(UserType userType);

	List<UserType> findAllUserTypes();
}
