package com.technolab.registrationsvc.clients;

import com.technolab.registrationsvc.dto.FormationDTO;
import com.technolab.registrationsvc.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ACADEMICSVC")
public interface FormationClient {
    @GetMapping("/academic/formation/{id}")
    FormationDTO findFormationById(@PathVariable long id);
}
