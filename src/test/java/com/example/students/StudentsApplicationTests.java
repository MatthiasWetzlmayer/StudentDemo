package com.example.students;

import com.example.students.exceptions.StudentNotFoundException;
import com.example.students.managers.StudentManager;
import com.example.students.repositories.MockRepo;
import com.example.students.services.StudentDataService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentsApplicationTests {
	@Test
	public void ManagerTest() throws StudentNotFoundException {
        StudentDataService service = new StudentDataService();
		assert service.getStudentById("test").getId().equals("test");
	}

}
