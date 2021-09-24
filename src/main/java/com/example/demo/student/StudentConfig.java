package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.AUGUST;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {

            Student mohammad = new Student(
                    "mohammad",
                    "mohammadian",
                    "mmohammadian25@gmail.com",
                    LocalDate.of(
                            1994,
                            AUGUST,
                            6)
            );
            Student kamal = new Student(
                    "kamal",
                    "kamali",
                    "kamail25@gmail.com",
                    LocalDate.of(
                            1994,
                            AUGUST,
                            6)
            );
            studentRepository.saveAll(
                    List.of(mohammad, kamal));
        };
    }
}
