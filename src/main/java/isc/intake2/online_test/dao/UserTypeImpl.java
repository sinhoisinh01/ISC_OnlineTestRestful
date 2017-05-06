package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.UserType;

@Repository("userTypeDao")
public class UserTypeImpl extends AbstractDaoImpl<Long, UserType> implements IUserTypeDao {
	public UserType findById(Long id){
		return getByKey(id);
	}
	
	public UserType findByName(String name){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (UserType) criteria.uniqueResult();
	}
	
	public void saveUserType(UserType userType){
		persist(userType);
	}
	
	public void saveOrUpdate(UserType userType){
		saveOrUpdate(userType);
	}
	
	public void deleteUserType(UserType userType){
		delete(userType);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<UserType> findAllUserTypes(){
		Criteria criteria = createEntityCriteria();
		return (List<UserType>) criteria.list();
	}
}
