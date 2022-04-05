package com.praktika2.demo.web.controllers;

import com.praktika2.demo.util.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CalculateController {
    private Parser parser;

    @Autowired
    CalculateController(Parser parser) {
        this.parser = parser;
    }

    @GetMapping("{values}")
    public String calculate(@PathVariable("values") String params) {
        return "<h1>Работы выполнил: Ануфриев Владислав Витальевич</h1>" +
                "<h1>Номер группы: ИКБО-02-17</h1>" +
                "<h1>Номер индвидуального задания: 4</h1>" +
                "<h1>Текст индвидуального задания: Подсчет четных и нечетных символов. Числа должны поступать" +
                "в виде строки с некоторым разделителем (пример: «11, 32, 1, 22, 14»); в" +
                "массиве; списком чисел.</h1>" +
                "<h1>Result:" +
                parser.parse(params) +
                "</h1>";
    }
}
