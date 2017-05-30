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

import isc.intake2.online_test.entities.AnswerType;
import isc.intake2.online_test.services.AnswerTypeServiceImpl;


@RestController
@RequestMapping(
		produces={"application/json; charset=UTF-8"}
	)
public class AnswerTypeCtrl implements IUrlCtrl  {
	
	@Autowired
	AnswerTypeServiceImpl answerTypeService;
	
	@RequestMapping(value = getAnswerType ,method = RequestMethod.GET)
	public ResponseEntity<List<AnswerType>> get() {
		List<AnswerType> answertypes = answerTypeService.findAllAnswerTypes();
		if (answertypes.isEmpty()) {
			return new ResponseEntity<List<AnswerType>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnswerType>>(answertypes, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = getAnswerTypeById,
			method = RequestMethod.GET
		)
		public ResponseEntity<AnswerType> get(@PathVariable("id") long id) {
		AnswerType answertype = answerTypeService.findById(id);
			if (answertype == null) {
				return new ResponseEntity<AnswerType>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<AnswerType>(answertype, HttpStatus.OK);
		}

	
}
