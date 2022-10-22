package com.example.new_school.repositoryies;

import com.example.new_school.dto.FacultyDto;
import com.example.new_school.models.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity,Long> {
    FacultyEntity findFacultyByColorIgnoreCase(String color);
    FacultyEntity findFacultyByNameIgnoreCase(String name);
}
