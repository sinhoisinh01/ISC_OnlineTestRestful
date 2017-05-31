package isc.intake2.online_test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isc.intake2.online_test.entities.Part;
import isc.intake2.online_test.entities.Subject;
import isc.intake2.online_test.services.PartServiceImpl;
import isc.intake2.online_test.services.SubjectServiceImpl;
import isc.intake2.online_test.services.IPartService;

@RestController
@RequestMapping(produces="application/json")
public class PartCtrl implements IUrlCtrl{

	@Autowired
	private IPartService partService;
	
	@Autowired
	private SubjectServiceImpl subjectService;
	
	//-------------------Retrieve All Parts--------------------------------------------------------
	
	@RequestMapping(value = getPart, method = RequestMethod.GET)
	public ResponseEntity<List<Part>> getPart(@PathVariable("subjectId") long subjectId){
		List<Part> parts = partService.findAllPart(subjectId);
		if(parts.isEmpty()){
			return new ResponseEntity<List<Part>>(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<List<Part>>(parts, HttpStatus.OK);
	}
	
	@RequestMapping(value = getPartforQ, method = RequestMethod.GET)
	public ResponseEntity<List<Part>> getPartforQ(){
		List<Part> parts = partService.findAllPartforQ();
		if(parts.isEmpty()){
			return new ResponseEntity<List<Part>>(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<List<Part>>(parts, HttpStatus.OK);
	}
	
	//-------------------Retrieve One Part--------------------------------------------------------
	@RequestMapping(value = getPartById, method = RequestMethod.GET)
	public ResponseEntity<Part> getPartById(@PathVariable("id") long id){
		Part part = partService.findById(id);
		if(part == null){
			return new ResponseEntity<Part>(HttpStatus.NO_CONTENT);
		}
			return new ResponseEntity<Part>(part, HttpStatus.OK);
	}
	
	//-------------------Create a Part--------------------------------------------------------
	@RequestMapping(value = createPart, method = RequestMethod.POST)
	public ResponseEntity<Void> createPart(@RequestBody Part part,
											@PathVariable("subjectId") long subjectId,
											UriComponentsBuilder ucBuilder){
		if(partService.isPartExist(part)){
    		System.out.println("A Subject with name " + part.getParName() + " already exist");
    		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    	}
		else
		{
			Subject subject = subjectService.findById(subjectId);
			Part newPart = new Part();
			newPart.setParId(part.getParId());
			newPart.setParName(part.getParName());
			newPart.setParDirection(part.getParDirection());
			newPart.setParDefault_level(part.getParDefault_level());
			newPart.setParDefault_score(part.getParDefault_score());
			newPart.setParDefault_column(part.getParDefault_column());
			newPart.setParOrder(part.getParOrder());
			newPart.setParNote(part.getParNote());
			newPart.setSubject(subject);
			partService.savePart(newPart);
			HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path(createPart).buildAndExpand(part.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	}
	
	//-------------------Update a Part--------------------------------------------------------
	@RequestMapping(value = updatePart, method = RequestMethod.PUT)
	public ResponseEntity<Void> updatePart(@PathVariable("subjectId") long subjectId,
											@PathVariable("id") long id,
											@RequestBody Part part,
											UriComponentsBuilder ucBuilder) {
		Part currentPart =  partService.findById(id);
		if(currentPart == null){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		else
		{
			Subject subject = subjectService.findById(subjectId);
			part.setSubject(subject);
			partService.saveOrUpdate(part);
			return new ResponseEntity<Void>(HttpStatus.OK);
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
