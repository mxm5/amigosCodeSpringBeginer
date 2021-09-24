package com.example.demo.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table
public class Student {

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birth;

    public Integer getAge() {
        return Period.between(this.birth,LocalDate.now()).getYears();
    }



    @Transient
    private Integer age;
    @Id
    @SequenceGenerator(
            name = "Student_sequence",
            allocationSize = 1,
            sequenceName = "Student_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Student_sequence"
    )
    private Long id;

    // constructor with no id
    public Student(
            String firstName,
            String lastName,
            String email,
            LocalDate birth
            ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birth = birth;

    }
}
