package com.jaju.lab4.util;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Parser {

    Parser() {

    }

    public String parse(final int[] numbers) {
        return parse(Arrays.stream(numbers).boxed().map(integer -> Integer.toString(integer)).collect(Collectors.joining(",")));
    }

    public String parse(@NotNull final List<Integer> numbers) {
        return parse(numbers.stream().map(integer -> Integer.toString(integer)).collect(Collectors.joining(",")));
    }

    public String parse(String str) {
        if (str.matches("([0-9]+[,.;]*)+")) {
            return Arrays.stream(str.trim().split("[, .;]"))
                    .filter(s -> !s.isEmpty()).map(Integer::parseInt)
                    .collect(Collectors.partitioningBy(s -> s % 2 == 0, Collectors.counting()))
                    .entrySet().stream()
                    .map(e -> e.getKey() ? "Even:" + e.getValue() : "Odd:" + e.getValue())
                    .collect(Collectors.joining("\t"));
        } else {
            return "wrong output";
        }
    }
}


