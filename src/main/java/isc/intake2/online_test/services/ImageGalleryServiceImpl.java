package isc.intake2.online_test.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isc.intake2.online_test.dao.IImageGalleryDao;
import isc.intake2.online_test.entities.ImageGallery;

@Service("imageGalleryService")
@Transactional
public class ImageGalleryServiceImpl implements IImageGalleryService{

	@Autowired
	private IImageGalleryDao imageGalleryDao;
	
	@Override
	public ImageGallery findById(long id) {
		return imageGalleryDao.findById(id);
	}

	@Override
	public ImageGallery findByUrl(String url) {
		return imageGalleryDao.findByUrl(url);
	}

	@Override
	public void save(ImageGallery image) {
		imageGalleryDao.saveImage(image);
		
	}

	@Override
	public void saveOrUpdate(ImageGallery image) {
		imageGalleryDao.saveOrUpdateImage(image);
		
	}

	@Override
	public void deleteImage(ImageGallery image) {
		imageGalleryDao.deleteImage(image);
		
	}

	@Override
	public List<ImageGallery> findAllImages(long partId) {
		return imageGalleryDao.findAllImages(partId);
	}

	public Boolean isImageExist(String url){
		return imageGalleryDao.isImageExist(url);
	}
	
}
