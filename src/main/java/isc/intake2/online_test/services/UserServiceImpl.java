package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.dao.IUserDao;
import isc.intake2.online_test.entities.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	public User findById(Long id){
		return userDao.findById(id);
	}
	
	public User findByName(String name){
		return userDao.findByName(name);
	}
	
	public void saveUser(User user){
		userDao.saveUser(user);
	}
	
	public void updateUser(User user){
		userDao.saveUser(user);
	}

	public void deleteUser(User user){
		userDao.deleteUser(user);
	}
	
	public List<User> findAllUsers(){
		return userDao.findAllUsers();
	}
}

