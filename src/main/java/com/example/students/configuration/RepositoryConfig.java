package com.example.students.configuration;

import com.example.students.repositories.IStudentRepository;
import com.example.students.repositories.MockRepo;
import com.example.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RepositoryConfig {
    public static final boolean TEST = false;

    @Autowired
    private StudentRepository repository;
    @Bean
    @Primary
    public IStudentRepository getRepo(){
        if(TEST){
            return new MockRepo();
        }else {
            return repository;
        }
    }
}
