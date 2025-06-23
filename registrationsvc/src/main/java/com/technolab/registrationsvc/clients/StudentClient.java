package com.technolab.registrationsvc.clients;

import com.technolab.registrationsvc.dto.StudentDTO;
import jakarta.persistence.Column;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

@FeignClient(name = "STUDENTSVC")
public interface StudentClient {
    @GetMapping("/student/etudiant/{id}")
    StudentDTO findStudentById(@PathVariable long id);
}
