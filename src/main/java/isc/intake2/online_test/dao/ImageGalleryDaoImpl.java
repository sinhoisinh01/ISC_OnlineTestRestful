//Hong
package isc.intake2.online_test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import isc.intake2.online_test.entities.ImageGallery;

@Repository("imageGalleryDao")
public class ImageGalleryDaoImpl extends AbstractDaoImpl<Long, ImageGallery> implements IImageGalleryDao{

	@Override
	public ImageGallery findById(long id){
		return getByKey(id);
	}
	
	@Override
	public ImageGallery findByUrl(String url){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("imageURL", url));
        return (ImageGallery) criteria.uniqueResult();
	}
	
	@Override
	public void saveImage(ImageGallery image){
		persist(image);
	}
	
	@Override
	public void saveOrUpdateImage(ImageGallery image){
		saveOrUpdate(image);
	}
	
	@Override
	public void deleteImage(ImageGallery image){
		delete(image);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ImageGallery> findAllImages(long partId){
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.sqlRestriction("{alias}.part_id = " + partId));
		return (List<ImageGallery>) criteria.list();
	}
	
	@Override
	public Boolean isImageExist(String url){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("imageURL", url));
        return (ImageGallery) criteria.uniqueResult() != null;
	}
}
