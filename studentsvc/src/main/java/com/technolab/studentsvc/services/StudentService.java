package com.technolab.studentsvc.services;

import com.technolab.studentsvc.models.Student;
import com.technolab.studentsvc.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student create(Student s){
        return studentRepository.save(s);
    }
    public List<Student> finAll(){
        return studentRepository.findAll();
    }
}
