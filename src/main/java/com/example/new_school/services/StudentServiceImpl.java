package com.example.new_school.services;

import com.example.new_school.Utils.StudentUtils;
import com.example.new_school.dto.StudentDto;
import com.example.new_school.models.StudentEntity;
import com.example.new_school.repositoryies.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    // заходит ли такой метод для миграции из ентити в дто?
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
        return studentRepository.findStudentByAge(age);
    }

    @Override
    public Collection<StudentDto> getStudentsByBetween(Integer min, Integer max) {
        return studentRepository.findByAgeBetween(min,max);
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
    public StudentDto deleteStudent(Long id) {
        StudentDto studentDto = StudentUtils.migrateEntityToDto(studentRepository.findById(id).get());
        studentRepository.deleteById(studentDto.getIdStudent());
        return studentDto;//тут я же правильно понял, раз он его удалил из базы, мы уже не можем его вернуть?
        // есть варинат получше нежели сначала создать эту сущность , удалить и вернуть
        // или же тут использвать ResponseEntity?
    }
}
