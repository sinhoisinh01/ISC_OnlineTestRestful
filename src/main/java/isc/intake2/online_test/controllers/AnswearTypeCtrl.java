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

import isc.intake2.online_test.entities.AnswearType;
import isc.intake2.online_test.services.AnswearTypeServiceImpl;


@RestController
@RequestMapping(
		produces={"application/json; charset=UTF-8"}
	)
public class AnswearTypeCtrl implements IUrlCtrl  {
	
	@Autowired
	AnswearTypeServiceImpl answearTypeService;
	
	@RequestMapping(value = getAnswearType ,method = RequestMethod.GET)
	public ResponseEntity<List<AnswearType>> get() {
		List<AnswearType> answeartypes = answearTypeService.findAllAnswearTypes();
		if (answeartypes.isEmpty()) {
			return new ResponseEntity<List<AnswearType>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnswearType>>(answeartypes, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = getAnswaerTypeById,
			method = RequestMethod.GET
		)
		public ResponseEntity<AnswearType> get(@PathVariable("id") long id) {
		AnswearType answeartype = answearTypeService.findById(id);
			if (answeartype == null) {
				return new ResponseEntity<AnswearType>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<AnswearType>(answeartype, HttpStatus.OK);
		}

	
}
