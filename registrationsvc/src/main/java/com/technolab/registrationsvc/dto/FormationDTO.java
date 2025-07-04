package com.technolab.registrationsvc.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormationDTO {
    private long id;
    private String  nom;
    private String niveau;
    private double tarif;
    private long  domaineID;
}
