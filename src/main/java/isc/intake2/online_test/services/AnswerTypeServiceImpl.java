//Hai
package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.dao.IAnswerTypeDao;
import isc.intake2.online_test.entities.AnswerType;

@Service("answearTypeService")
@Transactional
public class AnswerTypeServiceImpl implements IAnswerTypeService{

	@Autowired
	private IAnswerTypeDao answerTypeDao;
	
	public AnswerType findById(long id){
		return answerTypeDao.findById(id);
	}
	
	public List<AnswerType> findAllAnswerTypes(){
		return answerTypeDao.findAllAnswerType();
	}
}
