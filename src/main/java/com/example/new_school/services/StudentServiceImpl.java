package com.example.new_school.services;

import com.example.new_school.Utils.FacultyUtils;
import com.example.new_school.Utils.StudentUtils;
import com.example.new_school.dto.FacultyDto;
import com.example.new_school.dto.StudentDto;
import com.example.new_school.models.StudentEntity;
import com.example.new_school.repositoryies.FacultyRepository;
import com.example.new_school.repositoryies.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;
    @Override
    public StudentDto createStudent(StudentEntity entity) {
        return StudentUtils.migrateEntityToDto(studentRepository.save(entity));
    }

    @Override
    public Collection<StudentDto> getAllStudentsDto(){
        return StudentUtils.migrateEntityToDtoCollection(studentRepository.findAll());
    }

    @Override
    public Collection<StudentDto> getStudentsByAge(Integer age) {
        return StudentUtils.migrateEntityToDtoCollection(studentRepository.findStudentByAge(age));
    }

    @Override
    public Collection<StudentDto> getStudentsByBetween(Integer min, Integer max) {
        return StudentUtils.migrateEntityToDtoCollection(studentRepository.findByAgeBetween(min,max));
    }

    @Override
    public FacultyDto findFacultyByStudentId(Long studentId) {
        return FacultyUtils.migrateEntityToDto(facultyRepository.findFacultyByStudentId(studentId));
    }

    @Override
    public StudentDto getStudent(Long id) {
        return StudentUtils.migrateEntityToDto(studentRepository.findById(id).get());
    }

    @Override
    public StudentDto updateStudent(StudentEntity entity) {
        return StudentUtils.migrateEntityToDto(studentRepository.save(entity));
    }

    @Override
    public void deleteStudent(Long id) {
        StudentDto studentDto = StudentUtils.migrateEntityToDto(studentRepository.findById(id).get());
        studentRepository.deleteById(studentDto.getIdStudent());
        // есть варинат получше нежели сначала создать эту сущность , удалить и вернуть
        // или же тут использвать ResponseEntity?
    }
    public Long getCountAllStudents(){
        return studentRepository.getAllCountOfStudents();
    }

    @Override
    public Double getAvgAgeStudents() {
        return studentRepository.getAvgAgeStudents();
    }

    @Override
    public Collection<StudentDto> getFiveLastStudents() {
        return StudentUtils.migrateEntityToDtoCollection(studentRepository.findFiveLastStudents());
    }

}
