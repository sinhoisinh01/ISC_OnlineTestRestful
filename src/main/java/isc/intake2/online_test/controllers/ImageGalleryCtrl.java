package isc.intake2.online_test.controllers;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;

import org.apache.taglibs.standard.extra.spath.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import isc.intake2.online_test.entities.ImageGallery;
import isc.intake2.online_test.entities.Part;
import isc.intake2.online_test.services.IImageGalleryService;
import isc.intake2.online_test.services.IPartService;

@RestController

public class ImageGalleryCtrl implements IUrlCtrl{

	private final String hostName = "http://localhost:8080/onlinetest/images";
	@Autowired
	private IImageGalleryService imageGalleryService;
	
	@Autowired
	private IPartService partService;
	
	@Autowired
	private ServletContext servletContext;
	
	//-------------------Retrieve All Parts--------------------------------------------------------
	
	@RequestMapping(value = getImage, method = RequestMethod.GET)
	public ResponseEntity<List<ImageGallery>> getPart(@PathVariable("partId") long id){
		List<ImageGallery> images = imageGalleryService.findAllImages(id);
		
		int length = images.size();
		for(int i = 0; i < length ; i++)
		{
			images.get(i).setImageURL(hostName + "?imageName=" +images.get(i).getImageURL());
		}
		
		if(images.isEmpty()){
			return new ResponseEntity<List<ImageGallery>>(HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity<List<ImageGallery>>(images, HttpStatus.OK);
	}
	
	//-------------------Retrieve One Part--------------------------------------------------------
	@RequestMapping(value = getImageById, method = RequestMethod.GET)
	public ResponseEntity<ImageGallery> getPartById(@PathVariable("partId") long id){
		ImageGallery part = imageGalleryService.findById(id);
		if(part == null){
			return new ResponseEntity<ImageGallery>(HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity<ImageGallery>(part, HttpStatus.OK);
	}
	
	//-------------------UploadImage--------------------------------------------------------
	@RequestMapping(value = createImage, method = RequestMethod.POST)
	public ResponseEntity<?> uploadImage(@RequestPart("files[]") List<MultipartFile> files, @PathVariable("partId") long id, ServletResponse response) throws IllegalStateException, IOException{
		
		List<String> imagePath = new ArrayList<String>(0);
		List<String> imageUrl = new ArrayList<String>(0);
		Part part = partService.findById(id);
		boolean flag = true;
		String result = "[";
		
		
		if(part != null){
			File directory = new File(servletContext.getRealPath("images") + File.separator + part.getParName().replaceAll(" ", "_").toLowerCase());
			if(!directory.isDirectory()){
				directory.mkdirs();
			}
			for(int i = 0; i < files.size() ; i++)
			{
				imagePath.add(part.getParName().replaceAll(" ", "_").toLowerCase() + "/" + files.get(i).getOriginalFilename());
				imageUrl.add(directory.getPath() + File.separator + files.get(i).getOriginalFilename());
			}

		}
		for(int i = 0; i < imagePath.size(); i++){
			if(imagePath.isEmpty() || imageGalleryService.isImageExist(imagePath.get(i))){
				flag = false;
	    		
	    	}
			else
			{
				ImageGallery image = new ImageGallery();
				files.get(i).transferTo(new File(imageUrl.get(i)));
				image.setImageURL(imagePath.get(i));
				image.setPart(part);
				imageGalleryService.save(image);
				result += "{\"imageName\":\"" + hostName + "?imageName=" + imagePath + "\"}";
				if(i < imagePath.size()-1)
				{
					result += ",";
				}
				
			}
		}
		result += "]";
		if(flag)
		{
			return new ResponseEntity<>(result,HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	//-------------------removeImage--------------------------------------------------------
	@RequestMapping(value = deleteImage, method = RequestMethod.DELETE)
	public ResponseEntity<ImageGallery> removeImage(@PathVariable("id") long id) throws IllegalStateException, IOException{

		ImageGallery image = imageGalleryService.findById(id);
		if(imageGalleryService.isImageExist(image.getImageURL())){
			
			File file = new File(image.getImageURL());
			Files.deleteIfExists(file.toPath());
			
			
			imageGalleryService.deleteImage(image);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
			
	}
	
//	//-------------------Update a Part--------------------------------------------------------
//	@RequestMapping(value = updatePart, method = RequestMethod.PUT)
//	public ResponseEntity<Void> updatePart(@PathVariable("id") long id,
//											@RequestBody Part part,
//											UriComponentsBuilder ucBuilder) {
//		Part currentPart =  partService.findById(id);
//		if(currentPart == null){
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//		}
//		else
//		{
//			currentPart.setParName(part.getParName());
//			currentPart.setParDirection(part.getParDirection());
//			currentPart.setParDefault_column(part.getParDefault_column());
//			currentPart.setParDefault_level(part.getParDefault_level());
//			currentPart.setParDefault_score(part.getParDefault_score());
//			currentPart.setParNote(part.getParNote());
//			currentPart.setParOrder(part.getParOrder());
//			return new ResponseEntity<Void>(HttpStatus.CREATED);
//		}
//	}
//	
//	//-------------------Delete a Part--------------------------------------------------------
//	@RequestMapping(value = deletePart, method = RequestMethod.DELETE)
//	public ResponseEntity<Part> deletePart(@PathVariable("id") long id){
//		Part part = partService.findById(id);
//		if(part == null){
//			return new ResponseEntity<Part>(HttpStatus.NOT_FOUND);
//		}
//		else
//		{
//			partService.deletePart(part);
//			return new ResponseEntity<Part>(HttpStatus.OK);
//		}
//	}
}
