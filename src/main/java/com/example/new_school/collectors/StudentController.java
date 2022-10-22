package com.example.new_school.collectors;

import com.example.new_school.dto.StudentDto;
import com.example.new_school.models.StudentEntity;
import com.example.new_school.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
    //еще вопрос, правильно ли заинжекчена эта зависимость , или же нужно интерфейс инжектить?
    //не могу понять почему он выдает ошибку создания бина контроллера, тут же ломбок должен
    // все делать вместо конструктора
    // мы должны же инжектить класс сервиса , а не интерфейс?
    private final StudentService studentService; // в пол первого ночи понял , что нужно интерфейс
    //посмотри пожалуйста обзую логику:
    // правильно ли я понимаю что в контроллере мы передаем ентити в сервис
    // в сервисе мы переделываем его в ДТО(т.к. маппер я не подключил)
    // и возвращаем обратно ДТО. Если так , стоит ли использовать в контроллере
    // ResponseEntity ? Понимаю, что наименовая методов и эндпоинтов хромают,
    // не обращай пожалуйста на это внимание))
    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentEntity entity){
        return ResponseEntity.ok(studentService.createStudent(entity));
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudent(id));
    }
    @GetMapping("/printAll")
    public ResponseEntity<Collection<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudentsDto());
    }
    @GetMapping("/age/{age}")
    public ResponseEntity<Collection<StudentDto>> getStudentByAge(@PathVariable Integer age){
        return ResponseEntity.ok(studentService.getStudentsByAge(age));
    }
    @GetMapping({"minAge","maxAge"})
    public ResponseEntity<Collection<StudentDto>> getStudentsAgeByBetween(@RequestParam Integer minAge,
                                                                          @RequestParam Integer maxAge){
        return ResponseEntity.ok(studentService.getStudentsByBetween(minAge, maxAge));
    }
    @PutMapping
    public ResponseEntity<StudentDto> setStudent(@RequestBody StudentEntity entity){
        return ResponseEntity.ok(studentService.updateStudent(entity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
