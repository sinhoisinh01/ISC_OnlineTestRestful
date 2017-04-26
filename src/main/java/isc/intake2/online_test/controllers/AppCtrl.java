package isc.intake2.online_test.controllers;

import java.util.List;
import java.util.Locale;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import isc.intake2.online_test.entities.User;
import isc.intake2.online_test.services.UserServiceImpl;
 
@RestController
@RequestMapping(value = "/api",
				produces="application/json")
public class AppCtrl {
    @Autowired
    UserServiceImpl userService;
     
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = {"/user/"}, method = RequestMethod.GET)
    public ResponseEntity<User> listAllUsers() {
        User users = userService.findByName("hggntg");
        if(users == null){
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        System.out.println(users.getUserType().getUserTypeName());
        return new ResponseEntity<User>(users, HttpStatus.OK);
    }
 
 
}
