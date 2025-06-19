package com.technolab.registrationsvc.services;

import com.technolab.registrationsvc.models.Registration;
import com.technolab.registrationsvc.repositories.RegistrationRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    private final EntityManager em;
    @Autowired
    private RegistrationRepository registrationRepository;

    public RegistrationService(EntityManager em) {
        this.em = em;
    }

    public Registration create(Registration o){
        try {
            return registrationRepository.saveAndFlush(o);
        } catch (Exception e) {
            return null;
        }

    }
    public Registration update(Long id, Registration o) {
        try {
            return registrationRepository
                    .findById(id)
                    .map(oldEntity -> registrationRepository.saveAndFlush(o))
                    .orElseGet(() -> null);

        } catch (Exception e) {
            return null;
        }
    }
    public String delete(Long id) {
        try {
            Optional<Registration> optional = registrationRepository.findById(id);
            if (!optional.isPresent()) {
                return "error";
            }
            Registration o = optional.get();
            registrationRepository.delete(o);
            return "succes";
        } catch (Exception e) {
            return "error";
        }
    }

    public Registration findById(Long id) {
        try {
            return Optional.ofNullable(id)
                    .flatMap(registrationRepository::findById).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
    public List<Registration> finAll(){
        return registrationRepository.findAll();
    }


}
