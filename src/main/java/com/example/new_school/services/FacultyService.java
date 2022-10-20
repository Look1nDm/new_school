package com.example.new_school.services;

import com.example.new_school.dto.FacultyDto;
import com.example.new_school.models.FacultyEntity;

public interface FacultyService {

    FacultyDto createFaculty(FacultyEntity entity);

    FacultyDto getFaculty(Long id);

    FacultyDto updateFaculty(FacultyEntity entity);

    FacultyDto deleteFaculty(Long id);
}
