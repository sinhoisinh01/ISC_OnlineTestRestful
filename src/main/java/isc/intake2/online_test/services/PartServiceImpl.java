package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.dao.IPartDao;
import isc.intake2.online_test.dao.PartDaoImpl;
import isc.intake2.online_test.entities.Part;

@Service("partService")
@Transactional
public class PartServiceImpl implements IPartService{

	@Autowired
	private IPartDao partDao;
	
	@Override
	public Part findById(long id) {
		return partDao.findById(id);
	}

	@Override
	public Part findByName(String name) {
		return partDao.findByName(name);
	}

	@Override
	public void savePart(Part part) {
		partDao.savePart(part);
		
	}

	@Override
	public void saveOrUpdate(Part part) {
		partDao.saveOrUpdatePart(part);
		
	}

	@Override
	public void deletePart(Part part) {
		partDao.deletePart(part);
		
	}

	@Override
	public List<Part> findAllPart(long subjectId) {
		return partDao.findAllParts(subjectId);
	}

	public Boolean isPartExist(Part part){
		return partDao.isPartExist(part);
	}
	
}
