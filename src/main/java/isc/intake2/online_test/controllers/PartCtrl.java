package isc.intake2.online_test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isc.intake2.online_test.entities.Part;
import isc.intake2.online_test.services.PartServiceImpl;

@RestController
@RequestMapping(produces="application/json")
public class PartCtrl implements IUrlCtrl{

	@Autowired
	private PartServiceImpl partService;
	
	//-------------------Retrieve All Parts--------------------------------------------------------
	
	@RequestMapping(value = getPart, method = RequestMethod.GET)
	public ResponseEntity<List<Part>> getPart(@PathVariable("subjectId") long id){
		List<Part> parts = partService.findAllPart(id);
		if(parts.isEmpty()){
			return new ResponseEntity<List<Part>>(HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity<List<Part>>(parts, HttpStatus.OK);
	}
	
	//-------------------Retrieve One Part--------------------------------------------------------
	@RequestMapping(value = getPartById, method = RequestMethod.GET)
	public ResponseEntity<Part> getPartById(@PathVariable("id") long id){
		Part part = partService.findById(id);
		if(part == null){
			return new ResponseEntity<Part>(HttpStatus.NO_CONTENT);
		}
		else
			return new ResponseEntity<Part>(part, HttpStatus.OK);
	}
	
	//-------------------Create a Part--------------------------------------------------------
	@RequestMapping(value = createPart, method = RequestMethod.POST)
	public ResponseEntity<Void> createPart(@RequestBody Part part,
											UriComponentsBuilder ucBuilder){
		if(partService.isPartExist(part)){
    		System.out.println("A Subject with name " + part.getParName() + " already exist");
    		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    	}
		else
		{
			partService.savePart(part);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	//-------------------Update a Part--------------------------------------------------------
	@RequestMapping(value = updatePart, method = RequestMethod.PUT)
	public ResponseEntity<Void> updatePart(@PathVariable("id") long id,
											@RequestBody Part part,
											UriComponentsBuilder ucBuilder) {
		Part currentPart =  partService.findById(id);
		if(currentPart == null){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else
		{
			currentPart.setParName(part.getParName());
			currentPart.setParDirection(part.getParDirection());
			currentPart.setParDefault_column(part.getParDefault_column());
			currentPart.setParDefault_level(part.getParDefault_level());
			currentPart.setParDefault_score(part.getParDefault_score());
			currentPart.setParNote(part.getParNote());
			currentPart.setParOrder(part.getParOrder());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}
	
	//-------------------Delete a Part--------------------------------------------------------
	@RequestMapping(value = deletePart, method = RequestMethod.DELETE)
	public ResponseEntity<Part> deletePart(@PathVariable("id") long id){
		Part part = partService.findById(id);
		if(part == null){
			return new ResponseEntity<Part>(HttpStatus.NOT_FOUND);
		}
		else
		{
			partService.deletePart(part);
			return new ResponseEntity<Part>(HttpStatus.OK);
		}
	}
}
