package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.User;

public interface IUserService {
	User findById(Long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void saveOrUpdate(User user);
	
	void deleteUser(User user);

	List<User> findAllUsers();
	
	
}
