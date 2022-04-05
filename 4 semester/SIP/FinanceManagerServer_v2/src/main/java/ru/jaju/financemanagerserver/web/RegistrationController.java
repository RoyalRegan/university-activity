package ru.jaju.financemanagerserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jaju.financemanagerserver.exception.LoginAlreadyTakenException;
import ru.jaju.financemanagerserver.exception.ValidationException;
import ru.jaju.financemanagerserver.data.user.User;
import ru.jaju.financemanagerserver.data.repository.UserRepository;
import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/registration", produces ="application/json")
public class RegistrationController {
    private BCryptPasswordEncoder bCryptPasswordEncoder ;
    private final UserRepository userRepo;

    @Autowired
    public RegistrationController(UserRepository userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    public void registrationUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors() || user == null) {
            final List<String> errList = new LinkedList<>();
            errors.getFieldErrors().forEach(fieldError -> errList.add(fieldError.getDefaultMessage()));
            throw new ValidationException(errList);
        }
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepo.save(user);
        } catch (Exception ex) {
            throw new LoginAlreadyTakenException();
        }
    }
}
