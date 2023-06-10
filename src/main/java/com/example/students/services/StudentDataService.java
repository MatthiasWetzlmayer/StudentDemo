package com.example.students.services;

import com.example.students.exceptions.InvalidDateException;
import com.example.students.exceptions.StudentNotFoundException;
import com.example.students.managers.StudentManager;
import com.example.students.models.Student;
import com.example.students.models.StudentDto;
import com.example.students.models.StudentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class StudentDataService {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public List<StudentResource> getAllStudents() {
        return null;
    }

    public StudentResource getStudentById(String id) throws StudentNotFoundException {
        return null;
    }
    public StudentResource createStudent(StudentDto studentDto) throws Exception {
       return null;
    }

    //Wandelt ein Dto-Objekt in ein Student-Objekt um
    private Student convertStudentDtoToStudent(StudentDto dto) throws Exception {
        Student student = new Student();
        student.setFistName(dto.getFistName());
        student.setLastName(dto.getLastName());
        student.setAvgGrade(dto.getAvgGrade());
        student.setSchoolYear(dto.getSchoolYear());

        //TODO Datum überprüfen

        return student;
    }

    //Wandelt ein Student-Objekt in eine StudentResource um

    private StudentResource convertStudentToStudentResource(Student student){
        StudentResource resource = new StudentResource();
        resource.setId(student.getId());
        resource.setFistName(student.getFistName());
        resource.setLastName(student.getLastName());
        resource.setAvgGrade(student.getAvgGrade());
        resource.setSchoolYear(student.getSchoolYear());
        resource.setBirthDay(sdf.format(student.getBirthDay()));

        long difference = new Date().getTime() - student.getBirthDay().getTime();
        int age = (int) (difference / (1000L * 60 * 60 * 24 * 365.25));
        resource.setAge(age);

        return resource;
    }


}
