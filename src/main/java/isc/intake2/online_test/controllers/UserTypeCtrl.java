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

import isc.intake2.online_test.entities.UserType;
import isc.intake2.online_test.services.UserTypeServiceImpl;

@RestController
@RequestMapping(
	value = "api/usertype",
	produces={"application/json; charset=UTF-8"}
)
public class UserTypeCtrl {
	@Autowired
	UserTypeServiceImpl userTypeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserType>> get() {
		List<UserType> userTypes = userTypeService.findAllUserTypes();
		if (userTypes.isEmpty()) {
			return new ResponseEntity<List<UserType>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserType>>(userTypes, HttpStatus.OK);
	}
	
	@RequestMapping(
		value = "/{id}",
		method = RequestMethod.GET
	)
	public ResponseEntity<UserType> get(@PathVariable("id") long id) {
		UserType userType = userTypeService.findById(id);
		if (userType == null) {
			return new ResponseEntity<UserType>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<UserType>(userType, HttpStatus.OK);
	}
	
	 //-------------------Create a User--------------------------------------------------------
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody UserType userType, UriComponentsBuilder ucBuilder) {
    	System.out.println("yoyo");
        System.out.println("Creating User " + userType.getUserTypeName());
  
        /*if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
        //DigestUtils.
        //user.setUserEncPassword(DigestUtils.sha1Hex(user.getUserEncPassword()));
//        System.out.println(user.getUserType().getId());
        
        userTypeService.saveUserType(userType);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/userType/{id}").buildAndExpand(userType.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
      
    //------------------- Update a User --------------------------------------------------------
      
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserType> update(@PathVariable("id") long id, @RequestBody UserType userType) {
        System.out.println("Updating User " + id);
        
//        UserType currentUser = userTypeService.findById(id);
          
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
        
//        currentUser.setUserDate(user.getUserDate());
//        currentUser.setUserDOB(user.getUserDOB());
//        currentUser.setUserEmail(user.getUserEmail());
//        currentUser.setUserEncPassword(user.getUserEncPassword());
//        currentUser.setUserFirstName(user.getUserFirstName());
//        currentUser.setUserGender(user.getUserGender());
//        currentUser.setUserIsActive(user.getUserIsActive());
//        currentUser.setUserLastName(user.getUserLastName());
//        currentUser.setUserName(user.getUserName());
//        currentUser.setUserPhone(user.getUserPhone());
//        currentUser.setUserType(user.getUserType());
         
        System.out.println(userType.getUserTypeName());
        userTypeService.saveOrUpdateType(userType);;
        return new ResponseEntity<UserType>(HttpStatus.OK);
    }
  
    //------------------- Delete a User --------------------------------------------------------
      
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserType> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting UserType with id " + id);
  
        UserType userType = userTypeService.findById(id);
        if (userType == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<UserType>(HttpStatus.NOT_FOUND);
        }
  
        userTypeService.deleteUserType(userTypeService.findById(id));
        return new ResponseEntity<UserType>(HttpStatus.NO_CONTENT);
    }
}
