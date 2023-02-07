package com.eyecare.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.eyecare.entities.Registration;

@Component
public interface RegistrationRepository extends CrudRepository<Registration, Integer> {

	Optional<Registration> findByEmail(String email);

}
