package com.example.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RepositoryConfig {
    public static final boolean TEST = true;

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
