package com.example.students;

import com.example.students.exceptions.StudentNotFoundException;
import com.example.students.managers.StudentManager;
import com.example.students.repositories.IStudentRepository;
import com.example.students.repositories.MockRepo;
import com.example.students.services.StudentDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootTest
class StudentsApplicationTests {
	@Autowired
	private StudentDataService service;
	@Test
	public void TestAgeCalculation() throws StudentNotFoundException {
		assert service.getStudentById("test").getAge() == 23;
	}


}
