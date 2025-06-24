package com.technolab.registrationsvc.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private long id;
    @NotBlank
    private String  nom;
    private String  prenom;
    @Email
    private String  email;
    private Date dateNaiss;
}
