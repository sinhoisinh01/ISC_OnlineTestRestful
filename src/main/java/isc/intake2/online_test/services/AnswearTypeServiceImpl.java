//Hai
package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.dao.IAnswearTypeDao;
import isc.intake2.online_test.entities.AnswearType;

@Service("answearTypeService")
@Transactional
public class AnswearTypeServiceImpl implements IAnswearTypeService{

	@Autowired
	private IAnswearTypeDao answearTypeDao;
	
	public AnswearType findById(long id){
		return answearTypeDao.findById(id);
	}
	
	public List<AnswearType> findAllAnswearTypes(){
		return answearTypeDao.findAllAnswearType();
	}
}
