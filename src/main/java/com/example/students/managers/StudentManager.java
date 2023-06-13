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


    public Student createStudent(Student student){
        return null;
    }

    public List<Student> getAllStudents() {
        return null;
    }

    public Student getStudentById(String id) throws StudentNotFoundException {
       return null;
    }

    /*Wandelt ein Student Objekt in ein Datenbankobjekt um

    */

    /**
     * Wandelt ein Student Objekt in ein Datenbankobjekt um
     * @param student Das Studentobjekt, welches umgewandelt wird
     * @param create Wenn create true ist, wird der Wert createdAt im Entity auf die aktuelle Zeit gesetzt
     * @param update Wenn update true ist, wird der Wert updatedAt im Entity auf die aktuelle Zeit gesetzt
     * @return Das umgewandelte Entity
     */
    private StudentEntity convertStudentToEntity(Student student, boolean create, boolean update){
        StudentEntity entity = new StudentEntity();
        entity.setId(student.getId());
        entity.setFirstName(student.getFirstName());
        entity.setLastName(student.getLastName());
        entity.setBirthDay(student.getBirthDay());
        entity.setAvgGrade(student.getAvgGrade());
        if(create){
            entity.setCreatedAt(System.currentTimeMillis());
        }
        if(update){
            entity.setUpdatedAt(System.currentTimeMillis());
        }
        return entity;
    }

    //Wandelt ein Datenbankobjekt in ein Student Objekt um

    private Student convertEntityToStudent(StudentEntity entity){
        Student student = new Student();
        student.setId(entity.getId());
        student.setFirstName(entity.getFirstName());
        student.setLastName(entity.getLastName());
        student.setAvgGrade(entity.getAvgGrade());
        student.setBirthDay(entity.getBirthDay());
        return student;
    }
}
