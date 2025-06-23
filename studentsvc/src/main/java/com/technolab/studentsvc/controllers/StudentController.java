package com.technolab.studentsvc.controllers;

import com.technolab.studentsvc.exceptions.StudentNotFoundException;
import com.technolab.studentsvc.models.Student;
import com.technolab.studentsvc.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student/etudiant")
public class StudentController {
    //List<Student> students=new ArrayList<Student>();
    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> readStudents(){

        /*students.add(Student.builder()
                .id(1)
                .nom("TRAORE")
                .prenom("Moussa").build());
        students.add(Student.builder()
                .id(2)
                .nom("COULIBALY")
                .prenom("Fatoumata").build());*/
        return  studentService.finAll();
    }
    @PostMapping
    public Student createStudents(@RequestBody Student s){
        /*Student s=new Student();
        s.setId(1);
        s.setNom("Ali");*/
        //students.add(s);
        studentService.create(s);
        return s;
    }
    @PutMapping("/{id}")
    public void updateStudents(@PathVariable long id,@RequestBody Student us){
        /*Student s=new Student();
        s.setId(1);
        s.setNom("Ali");*/
        /*for(Student s:students){
            if(s.getId()==id){
                s.setNom(us.getNom());
                s.setPrenom(us.getPrenom());
            }
        }*/
    }

    @DeleteMapping("/{id}")
    public String  deleteStudents(@PathVariable long id){
        //students.removeIf((s)-> s.getId()==id);
        return "Student "+id+" is deleted successfuly !!!";
    }

    @GetMapping("/{id}")
    public Student getStudents(@PathVariable long id){
        return studentService.findById(id);
        /*return  students.stream().
                filter((s)->s.getId()==id).findFirst()
                .orElseThrow(()->new StudentNotFoundException(id));*/
    }

}
