package com.technolab.registrationsvc.repositories;


import com.technolab.registrationsvc.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {

}
