package com.example.students.controllers;

import com.example.students.services.StudentDataService;
import com.example.students.exceptions.StudentNotFoundException;
import com.example.students.models.StudentDto;
import com.example.students.models.StudentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentDataService dataService;

    @RequestMapping(method = RequestMethod.GET)
    public List<StudentResource> getAllStudents(){
        return dataService.getAllStudents();
    }

    //64888737902fa96e2d669f2a
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public StudentResource getStudentById(@PathVariable String id) throws StudentNotFoundException {
        return dataService.getStudentById(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public StudentResource createStudent(@RequestBody StudentDto studentDto) throws Exception {
        return dataService.createStudent(studentDto);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public StudentResource updateStudent(@PathVariable String id, @RequestBody StudentDto dto) throws Exception {
        return dataService.updateStudent(id, dto);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public StudentResource deleteStudent(@PathVariable String id) throws StudentNotFoundException {
        return dataService.deleteStudent(id);
    }


}
