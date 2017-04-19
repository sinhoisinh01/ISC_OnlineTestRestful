package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDaoImpl<Long, User> implements IUserDao {
	public User findById(Long id){
		return getByKey(id);
	}
	
	public User findByName(String name){
		return findByName(name);
	}
	
	public void saveUser(User user){
		persist(user);
	}
	
	public void deleteUser(User user){
		delete(user);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers(){
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}
	

}
