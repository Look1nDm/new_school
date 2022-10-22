package com.example.new_school.dto;

import com.example.new_school.models.StudentEntity;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDto {
    public Long idFaculty;
    public String name;
    public String color;
    public Set<StudentEntity> students;

    public FacultyDto(Long idFaculty, String name, String color) {
        this.idFaculty = idFaculty;
        this.name = name;
        this.color = color;
    }
}
