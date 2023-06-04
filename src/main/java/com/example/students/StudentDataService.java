package com.example.students;

import com.example.students.exceptions.InvalidDateException;
import com.example.students.exceptions.StudentNotFoundException;
import com.example.students.models.Student;
import com.example.students.models.StudentDto;
import com.example.students.models.StudentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class StudentDataService {
    @Autowired
    private StudentManager manager;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");



    public List<StudentResource> getAllStudents() {
        return manager.getAllStudents().stream().map(this::convertStudentToStudentResource).toList();
    }

    public StudentResource getStudentById(String id) throws StudentNotFoundException {
        return convertStudentToStudentResource(manager.getStudentById(id));
    }
    public StudentResource createStudent(StudentDto studentDto) throws Exception {
        return convertStudentToStudentResource(
                manager.createStudent(convertStudentDtoToStudent(studentDto))
        );
    }
    public StudentResource updateStudent(String id, StudentDto dto) throws Exception {
        Student student = convertStudentDtoToStudent(dto);
        student.setId(id);
        return convertStudentToStudentResource(manager.updateStudent(student));
    }

    public StudentResource deleteStudent(String id) throws StudentNotFoundException {
        return convertStudentToStudentResource(manager.deleteStudent(id));
    }
    private Student convertStudentDtoToStudent(StudentDto dto) throws Exception {
        Student student = new Student();
        student.setFistName(dto.getFistName());
        student.setLastName(dto.getLastName());
        student.setAvgGrade(dto.getAvgGrade());
        student.setSchoolYear(dto.getSchoolYear());

        try{
            Date date = sdf.parse(dto.getBirthDay());
            if(!date.before(new Date())){
                throw new InvalidDateException("Das Geburtsdatum darf nicht nach dem aktuellem Datum sein");
            }
            student.setBirthDay(date);
        }catch (Exception ex){
            throw new InvalidDateException("Das Geburtsdatum entspricht nicht dem richtigen Format");
        }


        return student;
    }

    private StudentResource convertStudentToStudentResource(Student student){
        StudentResource resource = new StudentResource();
        resource.setId(student.getId());
        resource.setFistName(student.getFistName());
        resource.setLastName(student.getLastName());
        resource.setAvgGrade(student.getAvgGrade());
        resource.setSchoolYear(student.getSchoolYear());

        long difference = new Date().getTime() - student.getBirthDay().getTime();
        int age = (int) (difference / (1000L * 60 * 60 * 24 * 365.25));

        resource.setAge(age);


        resource.setBirthDay(sdf.format(student.getBirthDay()));
        return resource;
    }


}
