package com.example.new_school.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;

}
