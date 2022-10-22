package com.example.new_school.services;

import com.example.new_school.Utils.FacultyUtils;
import com.example.new_school.dto.FacultyDto;
import com.example.new_school.models.FacultyEntity;
import com.example.new_school.repositoryies.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;

    @Override
    public FacultyDto createFaculty(FacultyEntity entity) {
        return FacultyUtils.migrateEntityToDto(facultyRepository.save(entity));
    }

    @Override
    public FacultyDto getFaculty(Long id) {
        return FacultyUtils.migrateEntityToDto(facultyRepository.findById(id).get());
    }

    @Override
    public FacultyDto updateFaculty(FacultyEntity entity) {
        return FacultyUtils.migrateEntityToDto(facultyRepository.save(entity));
    }

    @Override
    public FacultyDto deleteFaculty(Long id) {
        FacultyDto facultyDto = FacultyUtils.migrateEntityToDto(facultyRepository.findById(id).get());
        facultyRepository.deleteById(facultyDto.getIdFaculty());
        return facultyDto;
    }

    @Override
    public Collection<FacultyDto> getAllFaculties() {
        return FacultyUtils.migrateEntityToDtoCollection(facultyRepository.findAll());
    }

    @Override
    public FacultyDto getFacultyByColor(String color) {

        return FacultyUtils.migrateEntityToDto(facultyRepository.findFacultyByColorIgnoreCase(color));
    }

    @Override
    public FacultyDto getFacultyByName(String name) {
        return FacultyUtils.migrateEntityToDto(facultyRepository.findFacultyByNameIgnoreCase(name));
    }
}
