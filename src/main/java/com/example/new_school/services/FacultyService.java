package com.example.new_school.services;

import com.example.new_school.dto.FacultyDto;
import com.example.new_school.models.FacultyEntity;

import java.util.Collection;

public interface FacultyService {

    FacultyDto createFaculty(FacultyEntity entity);

    FacultyDto getFaculty(Long id);

    FacultyDto updateFaculty(FacultyEntity entity);

    FacultyDto deleteFaculty(Long id);

    Collection<FacultyDto> getAllFaculties();
    FacultyDto getFacultyByColor(String color);
    FacultyDto getFacultyByName(String name);
}
