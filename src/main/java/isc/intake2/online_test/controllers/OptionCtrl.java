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

import isc.intake2.online_test.entities.Option;
import isc.intake2.online_test.entities.User;
import isc.intake2.online_test.services.OptionServiceImpl;

@RestController
@RequestMapping(
		produces={"application/json; charset=UTF-8"}
	)
public class OptionCtrl implements IUrlCtrl  {
	
	@Autowired
	OptionServiceImpl optionService;
	
	@RequestMapping(value = getOption ,method = RequestMethod.GET)
	public ResponseEntity<List<Option>> get() {
		List<Option> options = optionService.findAllOptions();
		if (options.isEmpty()) {
			return new ResponseEntity<List<Option>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Option>>(options, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = getOptionById,
			method = RequestMethod.GET
		)
		public ResponseEntity<Option> get(@PathVariable("id") long id) {
		Option option = optionService.findById(id);
			if (option == null) {
				return new ResponseEntity<Option>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Option>(option, HttpStatus.OK);
		}
	
	@RequestMapping(value = createOption, method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody Option option, UriComponentsBuilder ucBuilder) {
           
		optionService.saveOption(option);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path(createOption).buildAndExpand(option.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	
	@RequestMapping(value = updateOption, method = RequestMethod.PUT)
    public ResponseEntity<Option> updateOption(@PathVariable("id") long id, @RequestBody Option option) {
		
		Option currentOption = optionService.findById(id);
		
		if (currentOption==null) {
          return new ResponseEntity<Option>(HttpStatus.NOT_FOUND);
		}
		     
        optionService.saveOrUpdateOption(option);
        return new ResponseEntity<Option>(HttpStatus.OK);
    }
	
	
	@RequestMapping(value = deleteOption, method = RequestMethod.DELETE)
    public ResponseEntity<Option> deleteOption(@PathVariable("id") long id) {
  
		Option option = optionService.findById(id);
        if (option == null) {
           
            return new ResponseEntity<Option>(HttpStatus.NOT_FOUND);
        }
  
        optionService.deleteOption(optionService.findById(id));
        return new ResponseEntity<Option>(HttpStatus.NO_CONTENT);
    }
	
}
