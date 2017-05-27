package isc.intake2.online_test.controllers;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import javax.servlet.ServletContext;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;


@RestController

public class ImageCtrl{
	
	@Autowired
	private ServletContext servletContext;
	
	//-------------------Retrieve All Parts--------------------------------------------------------
	
	@RequestMapping(value = "images", method = RequestMethod.GET,produces = "image/*")
	public ResponseEntity<byte[]> getPart(@RequestParam("imageName") String imageName) throws IOException{
		File image = new File(servletContext.getRealPath("images" + File.separator + imageName));
		if(image.exists()){
			Path path = Paths.get(image.getAbsolutePath());
			byte[] bytes = Files.readAllBytes(path);
			return new ResponseEntity<byte[]>(bytes, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}
			
	}
	
}
