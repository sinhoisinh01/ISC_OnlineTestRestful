//Hai
package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.dao.IOptionDao;
import isc.intake2.online_test.entities.Option;

@Service("optionService")
@Transactional
public class OptionServiceImpl implements IOptionService{

	@Autowired
	private IOptionDao optionDao;
	
	@Override
	public Option findById(long id){
		return optionDao.findById(id);
	}
	
	@Override
	public List<Option> findAllOptions(){
		return optionDao.findAllOption();
	}

	@Override
	public void saveOption(Option option) {
		// TODO Auto-generated method stub
		optionDao.saveOption(option);
	}

	@Override
	public void saveOrUpdateOption(Option option) {
		// TODO Auto-generated method stub
		optionDao.saveOrUpdateOption(option);
		
	}

	@Override
	public void deleteOption(Option option) {
		// TODO Auto-generated method stub
		optionDao.deleteOption(option);
	}
}
