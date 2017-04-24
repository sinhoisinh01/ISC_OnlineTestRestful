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

import isc.intake2.online_test.entities.Subject;
import isc.intake2.online_test.services.SubjectServiceImpl;

@RestController
@RequestMapping(value = "/api",
				produces="application/json")
public class SubjectCtrl {
	
	@Autowired
	SubjectServiceImpl subjectService;
	
	//-------------------Retrieve All Subjects--------------------------------------------------------
	
	@RequestMapping(value = "/subject/", method = RequestMethod.GET)
	public ResponseEntity<List<Subject>> listAllSubject(){
		List<Subject> subjects = subjectService.findAllSubjects();
		if(subjects.isEmpty()){
			return new ResponseEntity<List<Subject>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
	}
	
	//-------------------Retrieve One Subject--------------------------------------------------------
	@RequestMapping(value = "/subject/{id}", method = RequestMethod.GET)
	public ResponseEntity<Subject> getSubject(@PathVariable("id") long id){
		Subject subject = subjectService.findById(id);
		if(subject == null){
			return new ResponseEntity<Subject>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Subject>(subject, HttpStatus.OK);
	}
	
	//-------------------Create a User--------------------------------------------------------
    
    @RequestMapping(value = "/subject/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSubject(@RequestBody Subject subject, UriComponentsBuilder ucBuilder){
    	if(subjectService.isSubjectExist(subject)){
    		System.out.println("A Subject with name " + subject.getSubName() + " already exist");
    		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    	}
    	subjectService.saveSubject(subject);
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(ucBuilder.path("/subject/{id}").buildAndExpand(subject.getId()).toUri());
    	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/subject/{id}", method = RequestMethod.POST)
    public ResponseEntity<Subject> updateSubject(@PathVariable("id") long id, @RequestBody Subject subject){
    	Subject currentSubject = subjectService.findById(id);
    	if(currentSubject == null) {
    		return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
    	}
    	currentSubject.setSubId(subject.getSubId());
    	currentSubject.setSubName(subject.getSubName());
    	return new ResponseEntity<Subject>(HttpStatus.OK);
    }
    
  //------------------- Delete a Subject --------------------------------------------------------
    
    @RequestMapping(value = "/subject/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Subject> deleteUser(@PathVariable("id") long id) {
 
        Subject subject = subjectService.findById(id);
        if (subject == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
        }
 
        subjectService.deleteSubject(subject);
        return new ResponseEntity<Subject>(HttpStatus.NO_CONTENT);
    }
}
