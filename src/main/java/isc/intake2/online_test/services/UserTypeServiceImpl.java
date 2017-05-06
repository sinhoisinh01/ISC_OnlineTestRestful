package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.dao.IUserTypeDao;
import isc.intake2.online_test.entities.UserType;

@Service("userTypeService")
@Transactional
public class UserTypeServiceImpl implements IUserTypeService {

	@Autowired
	private IUserTypeDao userTypeDao;
	
	@Override
	public UserType findById(Long id) {
		return userTypeDao.findById(id);
	}

	@Override
	public UserType findByName(String name) {
		return userTypeDao.findByName(name);
	}

	@Override
	public void saveUserType(UserType userType) {
		userTypeDao.saveUserType(userType);
	}

	@Override
	public void saveOrUpdateType(UserType userType) {
		userTypeDao.saveOrUpdate(userType);
	}

	@Override
	public void deleteUserType(UserType userType) {
		userTypeDao.deleteUserType(userType);
	}

	@Override
	public List<UserType> findAllUserTypes() {
		return userTypeDao.findAllUserTypes();
	}

}
