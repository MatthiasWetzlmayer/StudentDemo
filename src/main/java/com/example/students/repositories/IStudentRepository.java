package com.example.students.repositories;

import com.example.students.models.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends MongoRepository<StudentEntity, String> {
}
