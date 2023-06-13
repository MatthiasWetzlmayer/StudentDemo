package com.example.students.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Student")
public class StudentEntity {
    private String id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private double avgGrade;
    private long createdAt;
    private long updatedAt;
}
