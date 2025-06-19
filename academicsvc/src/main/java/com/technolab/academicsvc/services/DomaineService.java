package com.technolab.academicsvc.services;

import com.technolab.academicsvc.models.Domaine;
import com.technolab.academicsvc.repositories.DomaineRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DomaineService {
    private final EntityManager em;
    @Autowired
    private DomaineRepository domaineRepository;

    public DomaineService(EntityManager em) {
        this.em = em;
    }

    public Domaine create(Domaine o){
        try {
            //System.out.println(o.getNom());
            return domaineRepository.saveAndFlush(o);
        } catch (Exception e) {
            return null;
        }

    }
    public Domaine update(Long id, Domaine o) {
        try {
            return domaineRepository
                    .findById(id)
                    .map(oldEntity -> domaineRepository.saveAndFlush(o))
                    .orElseGet(() -> null);

        } catch (Exception e) {
            return null;
        }
    }
    public String delete(Long id) {
        try {
            Optional<Domaine> optional = domaineRepository.findById(id);
            if (!optional.isPresent()) {
                return "error";
            }
            Domaine o = optional.get();
            domaineRepository.delete(o);
            return "succes";
        } catch (Exception e) {
            return "error";
        }
    }

    public Domaine findById(Long id) {
        try {
            return Optional.ofNullable(id)
                    .flatMap(domaineRepository::findById).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
    public List<Domaine> finAll(){
        return domaineRepository.findAll();
    }

    public List<Domaine> search(String nom) {
        List<Domaine> l = new ArrayList<Domaine>();
        String hql = "";
        try {
            hql += "FROM Domaine as o where o.id >0";
            if (nom != null && !nom.equals("") ) {
                hql += " and o.nom like '%" + nom + "%' ";
            }
            l = (List<Domaine>) em.createQuery(hql).getResultList();
            return l;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
}
