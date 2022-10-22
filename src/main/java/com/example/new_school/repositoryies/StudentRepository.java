package com.example.new_school.repositoryies;

import com.example.new_school.dto.StudentDto;
import com.example.new_school.models.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    Collection<StudentDto> findStudentByAge(Integer age);

    Collection<StudentDto> findByAgeBetween(Integer min,Integer max);
}
