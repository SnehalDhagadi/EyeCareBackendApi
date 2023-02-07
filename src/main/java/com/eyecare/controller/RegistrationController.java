package com.eyecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eyecare.dto.LoginDetails;
import com.eyecare.entities.Registration;
import com.eyecare.service.RegistrationService;

@Component
@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService registrationservice;

	@CrossOrigin(origins = "*", allowedHeaders = "*")

	@PostMapping(value = "/users")
	public String addRecord(@RequestBody Registration users) {
		if (registrationservice.getUserByEmail(users.getEmail()).isPresent()) {
			return "Email already exists";
		}
		registrationservice.addUser(users);
		return "Data with username " + users.getEmail() + " added succesfully";
	}
	@CrossOrigin
	@PostMapping(value = "/login")
	
	public String validateUser(@RequestBody LoginDetails userDetails) {
		String userEmail = userDetails.getEmail();
		String userPassword = userDetails.getPassword();

//		we got email and pass
//		Check the details in the db with that email.
//		check the passowrd of the result with the passwrod of the user.

		if (registrationservice.getUserByEmail(userEmail).isEmpty()) {
			return "No user with that email exists";
		}

		Registration storedUserDetails = registrationservice.getUserByEmail(userEmail).get();
		if (userEmail == storedUserDetails.getEmail() && userPassword == storedUserDetails.getPassword()) {
			return "Login Sucessfull";
		}

		return "Invalid login details";

	}

}
