package ru.jaju.financemanagerserver.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class ValidationException extends RuntimeException {
    @Getter
    private List<String> listOfMsg;

    public ValidationException(String listOfMsg) {
        this.listOfMsg = Collections.singletonList(listOfMsg);
    }
}
