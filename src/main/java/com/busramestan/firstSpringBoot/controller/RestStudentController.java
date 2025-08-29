package com.busramestan.firstSpringBoot.controller;

import com.busramestan.firstSpringBoot.entity.Student;
import com.busramestan.firstSpringBoot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("rest/api/student")
@RequiredArgsConstructor
public class RestStudentController {
    public final StudentService studentService;

    @PostMapping(path = "/save")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping(path ="/list")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}
