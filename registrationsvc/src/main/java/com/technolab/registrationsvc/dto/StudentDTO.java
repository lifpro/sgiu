package com.technolab.registrationsvc.dto;

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
    private String  nom;
    private String  prenom;
    private String  email;
    private Date dateNaiss;
}
