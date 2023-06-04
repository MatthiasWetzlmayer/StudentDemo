package com.example.students;


import com.example.students.models.Student;
import com.example.students.models.StudentEntity;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface StudentRepository extends IStudentRepository {

}
