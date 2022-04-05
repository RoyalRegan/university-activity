package com.jaju.lab3.web.controllers;

import com.jaju.lab3.data.Student;
import com.jaju.lab3.util.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/")
public class OperationController {
    private Set<Student> students = new HashSet<>();
    private Parser parser;

    @Autowired
    OperationController(Parser parser) {
        this.parser = parser;
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
    Collection<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public Map addStudent(@RequestBody Student student) {
        students.add(student);
        return Collections.singletonMap("id", student.getId());
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        students.forEach(s -> {
            if (s.getId() == id) {
                s.setFio(student.getFio());
                s.setGroup(student.getGroup());
            }
        });
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        students.removeIf(student -> student.getId() == id);
    }
}
