package isc.intake2.online_test.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isc.intake2.online_test.entities.User;

@RestController
@RequestMapping(
	value = "/login", 
	produces = "application/json;charset=UTF-8"
)
public class LoginCtrl {
	@RequestMapping(produces = "application/json;charset=UTF-8")
	public User get() {
		return new User(1, "sinhoisinh", "123456", "Sinh", "Đoàn", "01/04/1995", false, "doanphucsinh@gmail.com", "0907 859 233", true);
	}
}
