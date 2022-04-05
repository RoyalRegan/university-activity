package ru.jaju.financemanagerserver.web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.jaju.financemanagerserver.data.user.User;
import ru.jaju.financemanagerserver.data.repository.UserRepository;
import ru.jaju.financemanagerserver.exception.LoginAlreadyTakenException;
import ru.jaju.financemanagerserver.exception.IncorrectPasswordException;
import ru.jaju.financemanagerserver.exception.WrongJsonException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/user", produces ="application/json")
public class UserController {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PutMapping
    public void changeUser(HttpServletRequest request, @AuthenticationPrincipal String userId) throws IOException {
        JsonObject jsonObject = new Gson().fromJson(request.getReader(), JsonObject.class);
        if (jsonObject == null) {
            throw new WrongJsonException();
        }
        User userDb = userRepo.findById(Integer.parseInt(userId)).get();
        if (!jsonObject.has("password") ||
                !bCryptPasswordEncoder.matches(jsonObject.get("password").getAsString(), userDb.getPassword())) {
            throw new IncorrectPasswordException();
        }
        if (jsonObject.has("login") && Strings.isNotBlank(jsonObject.get("login").getAsString())) {
            userDb.setLogin(jsonObject.get("login").getAsString());
        }
        if (jsonObject.has("new_password") && Strings.isNotBlank(jsonObject.get("new_password").getAsString())) {
            userDb.setPassword(jsonObject.get("newPas").getAsString());
        }
        try {
            userRepo.save(userDb);
        } catch (Exception ex) {
            throw new LoginAlreadyTakenException();
        }
    }

    @DeleteMapping
    public void deleteUser(HttpServletRequest request, @AuthenticationPrincipal String userId) throws IOException {
        User userDb = userRepo.findById(Integer.parseInt(userId)).get();
        JsonObject jsonObject = new Gson().fromJson(request.getReader(), JsonObject.class);
        if (jsonObject == null || !jsonObject.has("password")) {
            throw new WrongJsonException();
        }
        if (!bCryptPasswordEncoder.matches(jsonObject.get("password").getAsString(), userDb.getPassword())) {
            throw new IncorrectPasswordException();
        }
        userRepo.delete(userDb);
    }
}
