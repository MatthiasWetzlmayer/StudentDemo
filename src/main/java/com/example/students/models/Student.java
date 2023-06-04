package com.example.students.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
public class Student {
    private String id;
    private String fistName;
    private String lastName;
    private Date birthDay;
    private double avgGrade;
    private int schoolYear;
}
