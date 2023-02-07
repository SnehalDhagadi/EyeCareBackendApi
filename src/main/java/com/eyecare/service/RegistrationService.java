package com.eyecare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eyecare.entities.Registration;
import com.eyecare.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	RegistrationRepository registrationRepository;

	public void addUser(Registration users) {
		registrationRepository.save(users);

	}

	public Optional<Registration> getUserByEmail(String email) {
		
		
		return registrationRepository.findByEmail(email);
	}

}
