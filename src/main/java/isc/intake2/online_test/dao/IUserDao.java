//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.User;

public interface IUserDao {
	User findById(Long id);

	User findByName(String name);
	
	void saveUser(User user);
	
	void deleteUser(User user);
	
	List<User> findAllUsers();
	
	
}
