package com.example.students.controllers;

import com.example.students.services.StudentDataService;
import com.example.students.exceptions.StudentNotFoundException;
import com.example.students.models.StudentDto;
import com.example.students.models.StudentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    public List<StudentResource> getAllStudents(){
        return null;
    }

    //64888737902fa96e2d669f2a
    public StudentResource getStudentById(String id) throws StudentNotFoundException {
        return null;
    }
    public StudentResource createStudent(StudentDto studentDto) throws Exception {
        return null;
    }

}
