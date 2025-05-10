package com.example.demo.config;

import com.example.demo.Model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner1(StudentRepository repo)
    {
        return args -> {
            Student student1=new Student(
                    1,
                    "zayneb",
                    "hamdi.zayneb123@gmail.com"
            );

            repo.save(student1);
        };
    }
}
