package com.example.new_school.collectors;

import com.example.new_school.dto.FacultyDto;
import com.example.new_school.models.FacultyEntity;
import com.example.new_school.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @PostMapping("/create")
    public FacultyDto createStudent(@RequestBody FacultyEntity entity){
        return facultyService.createFaculty(entity);
    }
    @GetMapping("/{id}")
    public FacultyDto getStudent(@PathVariable Long id){
        return facultyService.getFaculty(id);
    }
    @PutMapping
    public FacultyDto setStudent(@RequestBody FacultyEntity entity){
        return facultyService.updateFaculty(entity);
    }
    @DeleteMapping("/{id}")
    public FacultyDto deleteStudent(@PathVariable Long id){
        return facultyService.deleteFaculty(id);
    }
}
