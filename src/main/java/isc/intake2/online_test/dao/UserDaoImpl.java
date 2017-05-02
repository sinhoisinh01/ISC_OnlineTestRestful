//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDaoImpl<Long, User> implements IUserDao {
	public User findById(Long id){
		return getByKey(id);
	}
	
	public User findByName(String username){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("userName", username));
        return (User) criteria.uniqueResult();
	}
	
	public void saveUser(User user){
		persist(user);
	}
	
	public void saveOrUpdate(User user){
		super.saveOrUpdate(user);
	}
	
	public void deleteUser(User user){
		super.delete(user);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers(){
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}
	

}
