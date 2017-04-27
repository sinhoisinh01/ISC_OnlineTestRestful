package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.UserType;

public interface IUserTypeDao {
	UserType findById(Long id);

	UserType findByName(String name);
	
	void saveUserType(UserType userType);
	
	void saveOrUpdate(UserType userType);
	
	void deleteUserType(UserType userType);
	
	List<UserType> findAllUserTypes();
	
	
}
