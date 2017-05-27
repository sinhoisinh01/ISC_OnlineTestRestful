//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import isc.intake2.online_test.entities.ImageGallery;

public interface IImageGalleryDao {

	ImageGallery findById(long id);
	
	ImageGallery findByUrl(String url);
	
	void saveImage(ImageGallery image);
	
	void saveOrUpdateImage(ImageGallery image);
	
	void deleteImage(ImageGallery image);
	
	List<ImageGallery> findAllImages(long partId);

	Boolean isImageExist(String url);

}
