package isc.intake2.online_test.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isc.intake2.online_test.entities.User;

@RestController
@RequestMapping(
	value = "/", 
	produces = "application/json;charset=UTF-8"
)
public class LoginCtrl {
	@RequestMapping(value = {"admin/login","login"},produces = "application/json;charset=UTF-8")
	public User get() {
		return null;
	}
}
