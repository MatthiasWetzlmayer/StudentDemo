package com.example.students.managers;


import com.example.students.exceptions.StudentNotFoundException;
import com.example.students.models.Student;
import com.example.students.models.StudentEntity;
import com.example.students.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentManager {
    @Autowired
    private IStudentRepository repository;


    public Student createStudent(Student student){
        return convertEntityToStudent(
                repository.save(
                        convertStudentToEntity(student,true,false)
                ));
    }

    public List<Student> getAllStudents() {
        return repository.findAll().stream().map(this::convertEntityToStudent).toList();
    }

    public Student getStudentById(String id) throws StudentNotFoundException {
        Optional<StudentEntity> entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new StudentNotFoundException("Der Schüler mit der Id"+ id+ "existiert nicht");
        }

        return convertEntityToStudent(entity.get());
    }

    public Student updateStudent(Student student) throws StudentNotFoundException {
        if(!repository.existsById(student.getId())){
            throw new StudentNotFoundException("Der Schüler mit der Id"+ student.getId()+ "existiert nicht");
        }
        return convertEntityToStudent(
                repository.save(
                        convertStudentToEntity(student,false,true)
                ));
    }

    public Student deleteStudent(String id) throws StudentNotFoundException {
        Optional<StudentEntity> opt = repository.findById(id);
        if(opt.isEmpty()){
            throw new StudentNotFoundException("Der Schüler mit der Id"+ id + "existiert nicht");
        }

        StudentEntity entity = opt.get();
        repository.delete(entity);
        return convertEntityToStudent(entity);
    }

    private StudentEntity convertStudentToEntity(Student student, boolean create, boolean update){
        StudentEntity entity = new StudentEntity();
        entity.setId(student.getId());
        entity.setFirstName(student.getFirstName());
        entity.setLastName(student.getLastName());
        entity.setBirthDay(student.getBirthDay());
        entity.setAvgGrade(student.getAvgGrade());
        entity.setSchoolYear(entity.getSchoolYear());
        if(create){
            entity.setCreatedAt(System.currentTimeMillis());
        }
        if(update){
            entity.setUpdatedAt(System.currentTimeMillis());
        }
        return entity;
    }

    private Student convertEntityToStudent(StudentEntity entity){
        Student student = new Student();
        student.setId(entity.getId());
        student.setFirstName(entity.getFirstName());
        student.setLastName(entity.getLastName());
        student.setAvgGrade(entity.getAvgGrade());
        student.setSchoolYear(entity.getSchoolYear());
        student.setBirthDay(entity.getBirthDay());
        return student;
    }
}
