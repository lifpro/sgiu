package com.technolab.studentsvc.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(long id) {
        super("Student with ID "+id+" not found");
    }

}
