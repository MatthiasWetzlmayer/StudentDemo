package com.example.students.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDto {
    private String fistName;
    private String lastName;
    private String birthDay;
    private double avgGrade;
    private int schoolYear;
}
