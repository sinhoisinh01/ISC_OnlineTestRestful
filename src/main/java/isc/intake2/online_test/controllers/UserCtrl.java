package isc.intake2.online_test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.codec.digest.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isc.intake2.online_test.entities.User;
import isc.intake2.online_test.services.UserServiceImpl;

@RestController
@RequestMapping(
	produces="application/json"
)
public class UserCtrl implements IUrlCtrl{

	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value = getUser ,method = RequestMethod.GET)
	public ResponseEntity<List<User>> get() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(
		value = getUserById,
		method = RequestMethod.GET
	)
	public ResponseEntity<User> get(@PathVariable("id") long id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	 //-------------------Create a User--------------------------------------------------------
    
    @RequestMapping(value = createUser, method = RequestMethod.POST)
    public ResponseEntity<Void> add(@RequestBody User user, UriComponentsBuilder ucBuilder) {
    	System.out.println("yoyo");
        System.out.println("Creating User " + user.getUserName());
  
        /*if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
        //DigestUtils.
        //user.setUserEncPassword(DigestUtils.sha1Hex(user.getUserEncPassword()));
//        System.out.println(user.getUserType().getId());
        
        userService.saveUser(user);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path(createUser).buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
      
    //------------------- Update a User --------------------------------------------------------
      
    @RequestMapping(value = updateUser, method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);
          
        User currentUser = userService.findById(id);
          
        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        
        currentUser.setUserDate(user.getUserDate());
        currentUser.setUserDOB(user.getUserDOB());
        currentUser.setUserEmail(user.getUserEmail());
        currentUser.setUserEncPassword(user.getUserEncPassword());
        currentUser.setUserFirstName(user.getUserFirstName());
        currentUser.setUserGender(user.getUserGender());
        currentUser.setUserIsActive(user.getUserIsActive());
        currentUser.setUserLastName(user.getUserLastName());
        currentUser.setUserName(user.getUserName());
        currentUser.setUserPhone(user.getUserPhone());
        currentUser.setUserType(user.getUserType());
         
        System.out.println(currentUser.getUserFirstName());
        userService.saveOrUpdate(currentUser);
        return new ResponseEntity<User>(HttpStatus.OK);
    }
  
    //------------------- Delete a User --------------------------------------------------------
      
    @RequestMapping(value = deleteUser, method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
  
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
  
        userService.deleteUser(userService.findById(id));
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
