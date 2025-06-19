package com.technolab.academicsvc.repositories;

import com.technolab.academicsvc.models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FormationRepository extends JpaRepository<Formation,Long> {

}
