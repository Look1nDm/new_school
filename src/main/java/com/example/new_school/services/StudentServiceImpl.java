package com.example.new_school.services;

import com.example.new_school.dto.StudentDto;
import com.example.new_school.models.StudentEntity;
import com.example.new_school.repositoryies.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentDto migrateEntityToDto(StudentEntity entity){
        return new StudentDto(entity.getId(), entity.getName(),entity.getAge());
        // заходит ли такой метод для миграции из ентити в дто?
    }
    @Override
    public StudentDto createStudent(StudentEntity entity) {
        return migrateEntityToDto(studentRepository.save(entity));
    }
    @Override
    public StudentDto getStudent(Long id) {
        return migrateEntityToDto(studentRepository.findById(id).get());
    }

    @Override
    public StudentDto updateStudent(StudentEntity entity) {
        return migrateEntityToDto(studentRepository.save(entity));
    }

    @Override
    public StudentDto deleteStudent(Long id) {
        StudentDto studentDto = migrateEntityToDto(studentRepository.findById(id).get());
        studentRepository.deleteById(studentDto.getIdStudent());
        return studentDto;//тут я же правильно понял, раз он его удалил из базы, мы уже не можем его вернуть?
        // есть варинат получше нежели сначала создать эту сущность , удалить и вернуть
        // или же тут использвать ResponseEntity?
    }
}
