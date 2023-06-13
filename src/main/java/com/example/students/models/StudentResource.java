package com.example.students.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentResource {
    private String id;
    private String firstName;
    private String lastName;
    private String birthDay;
    private double avgGrade;
    private int age;
}
