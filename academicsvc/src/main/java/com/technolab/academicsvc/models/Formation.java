package com.technolab.academicsvc.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "formation")
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String  nom;
    @Column
    @Enumerated(EnumType.STRING)
    private NiveauFormation niveau;
    @Column()
    private int duree;
    private long  domaineID;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(foreignKey = @ForeignKey(value =ConstraintMode.NO_CONSTRAINT ),name = "domaineID",referencedColumnName = "id", insertable = false, updatable = false)
    private Domaine domaine;
}
