package com.technolab.studentsvc.services;

import com.technolab.studentsvc.models.Student;
import com.technolab.studentsvc.repositories.StudentRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final EntityManager em;
    @Autowired
    private StudentRepository studentRepository;

    public StudentService(EntityManager em) {
        this.em = em;
    }

    public Student create(Student o){
        try {
            return studentRepository.saveAndFlush(o);
        } catch (Exception e) {
            return null;
        }

    }
    public Student update(Long id, Student o) {
        try {
            return studentRepository
                    .findById(id)
                    .map(oldEntity -> studentRepository.saveAndFlush(o))
                    .orElseGet(() -> null);

        } catch (Exception e) {
            return null;
        }
    }
    public String delete(Long id) {
        try {
            Optional<Student> optional = studentRepository.findById(id);
            if (!optional.isPresent()) {
                return "error";
            }
            Student o = optional.get();
            studentRepository.delete(o);
            return "succes";
        } catch (Exception e) {
            return "error";
        }
    }

    public Student findById(Long id) {
        try {
            return Optional.ofNullable(id)
                    .flatMap(studentRepository::findById).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
    public List<Student> finAll(){
        return studentRepository.findAll();
    }

    public List<Student> search(String nom) {
        List<Student> l = new ArrayList<Student>();
        String hql = "";
        try {
            hql += "FROM Student as o where o.id >0";
            if (nom != null && !nom.equals("") ) {
                hql += " and o.nom like '%" + nom + "%' ";
            }
            l = (List<Student>) em.createQuery(hql).getResultList();
            return l;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
}
