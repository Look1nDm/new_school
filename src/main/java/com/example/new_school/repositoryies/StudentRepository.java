package com.example.new_school.repositoryies;

import com.example.new_school.models.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
