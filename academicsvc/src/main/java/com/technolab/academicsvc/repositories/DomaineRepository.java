package com.technolab.academicsvc.repositories;

import com.technolab.academicsvc.models.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine,Long> {

}
