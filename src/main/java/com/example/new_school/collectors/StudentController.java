package com.example.new_school.collectors;

import com.example.new_school.dto.StudentDto;
import com.example.new_school.models.StudentEntity;
import com.example.new_school.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public StudentDto createStudent(@RequestBody StudentEntity entity){
        return studentService.createStudent(entity);
    }
    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }
    @PutMapping
    public StudentDto setStudent(@RequestBody StudentEntity entity){
        return studentService.updateStudent(entity);
    }
    @DeleteMapping("/{id}")
    public StudentDto deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
