package com.jaju.lab4.web.controllers;

import com.jaju.lab4.data.Student;
import com.jaju.lab4.data.StudentRepository;
import com.jaju.lab4.util.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/")
public class OperationController {
    private StudentRepository studentRepository;
    private Parser parser;

    @Autowired
    OperationController(Parser parser, StudentRepository studentRepository) {
        this.parser = parser;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/calculate")
    public @ResponseBody
    HashMap calculate(@RequestParam("str") String str) {
        HashMap<String, String> result = new HashMap<>();
        result.put("value", parser.parse(str));
        return result;
    }

    @GetMapping("/students")
    public @ResponseBody
    Iterable<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/students")
    public Map addStudent(@RequestBody Student student) {
        return Collections.singletonMap("id", studentRepository.save(student).getId());
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        Student fromDb = studentRepository.findById(id).get();
        fromDb.setFio(student.getFio());
        fromDb.setGroup(student.getGroup());
        studentRepository.save(fromDb);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
    }
}
