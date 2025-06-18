package com.technolab.studentsvc.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
public class Student {
    private long id;
    private String  nom;
    private String  prenom;
    private Date dateNaiss;
}
