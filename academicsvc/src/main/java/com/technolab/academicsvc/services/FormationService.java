package com.technolab.academicsvc.services;

import com.technolab.academicsvc.models.Formation;
import com.technolab.academicsvc.repositories.FormationRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FormationService {
    private final EntityManager em;
    @Autowired
    private FormationRepository formationRepository;

    public FormationService(EntityManager em) {
        this.em = em;
    }

    public Formation create(Formation o){
        try {
            return formationRepository.saveAndFlush(o);
        } catch (Exception e) {
            return null;
        }

    }
    public Formation update(Long id, Formation o) {
        try {
            return formationRepository
                    .findById(id)
                    .map(oldEntity -> formationRepository.saveAndFlush(o))
                    .orElseGet(() -> null);

        } catch (Exception e) {
            return null;
        }
    }
    public String delete(Long id) {
        try {
            Optional<Formation> optional = formationRepository.findById(id);
            if (!optional.isPresent()) {
                return "error";
            }
            Formation o = optional.get();
            formationRepository.delete(o);
            return "succes";
        } catch (Exception e) {
            return "error";
        }
    }

    public Formation findById(Long id) {
        try {
            return Optional.ofNullable(id)
                    .flatMap(formationRepository::findById).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
    public List<Formation> finAll(){
        return formationRepository.findAll();
    }

    public List<Formation> search(String nom) {
        List<Formation> l = new ArrayList<Formation>();
        String hql = "";
        try {
            hql += "FROM Formation as o where o.id >0";
            if (nom != null && !nom.equals("") ) {
                hql += " and o.nom like '%" + nom + "%' ";
            }
            l = (List<Formation>) em.createQuery(hql).getResultList();
            return l;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
}
