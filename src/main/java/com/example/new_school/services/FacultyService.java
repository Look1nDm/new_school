package com.example.new_school.services;

import com.example.new_school.dto.FacultyDto;
import com.example.new_school.dto.StudentDto;
import com.example.new_school.models.FacultyEntity;

import java.util.Collection;

public interface FacultyService {

    FacultyDto createFaculty(FacultyEntity entity);

    FacultyDto getFaculty(Long id);

    FacultyDto updateFaculty(FacultyEntity entity);

    void deleteFaculty(Long id);

    Collection<FacultyDto> getAllFaculties();
    FacultyDto getFacultyByColor(String color);
    FacultyDto getFacultyByName(String name);
    Collection<StudentDto> getStudentsOfFaculty(Long id);
}
