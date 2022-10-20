package com.example.new_school.services;

import com.example.new_school.dto.FacultyDto;
import com.example.new_school.models.FacultyEntity;
import com.example.new_school.repositoryies.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyDto migrateEntityToDto(FacultyEntity entity) {
        return new FacultyDto(entity.getId(), entity.getName(),entity.getColor());

    }
    @Override
    public FacultyDto createFaculty(FacultyEntity entity) {
        return migrateEntityToDto(facultyRepository.save(entity));
    }

    @Override
    public FacultyDto getFaculty(Long id) {
        return migrateEntityToDto(facultyRepository.findById(id).get());
    }

    @Override
    public FacultyDto updateFaculty(FacultyEntity entity) {
        return migrateEntityToDto(facultyRepository.save(entity));
    }

    @Override
    public FacultyDto deleteFaculty(Long id) {
        FacultyDto facultyDto = migrateEntityToDto(facultyRepository.findById(id).get());
        facultyRepository.deleteById(facultyDto.getIdFaculty());
        return facultyDto;
    }
}
