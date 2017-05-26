package isc.intake2.online_test.services;

import java.util.List;

import isc.intake2.online_test.entities.ImageGallery;

public interface IImageGalleryService {

	ImageGallery findById(long id);
	
	ImageGallery findByUrl(String url);
	
	void save(ImageGallery image);
	
	void saveOrUpdate(ImageGallery image);
	
	void deleteImage(ImageGallery image);
	
	List<ImageGallery> findAllImages(long partId);
	
	Boolean isImageExist(String url);
}
