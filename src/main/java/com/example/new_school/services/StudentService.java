package com.example.new_school.services;

import com.example.new_school.dto.StudentDto;
import com.example.new_school.models.StudentEntity;

public interface StudentService {
    StudentDto createStudent(StudentEntity entity);

    StudentDto getStudent(Long id);

    StudentDto updateStudent(StudentEntity entity);

    StudentDto deleteStudent(Long id);
}
