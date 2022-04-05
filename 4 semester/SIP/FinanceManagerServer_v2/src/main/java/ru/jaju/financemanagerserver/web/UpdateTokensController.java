package ru.jaju.financemanagerserver.web;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.jaju.financemanagerserver.data.repository.UserRepository;
import ru.jaju.financemanagerserver.util.TokenFactory;

import javax.servlet.http.HttpServletRequest;

import static ru.jaju.financemanagerserver.security.SecurityConstants.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/updateTokens", produces ="application/json")
public class UpdateTokensController {
    private TokenFactory tokenFactory;
    private UserRepository userRepository;

    @Autowired
    public UpdateTokensController(UserRepository userRepository, TokenFactory tokenFactory) {
        this.userRepository = userRepository;
        this.tokenFactory = tokenFactory;
    }

    @GetMapping
    public ResponseEntity updateTokens(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            token = token.replace(TOKEN_PREFIX, "");
            int id = Integer.parseInt(JWT.decode(token).getSubject());
            byte[] secret = userRepository.findById(id).get().getSecret();
            JWT.require(Algorithm.HMAC512(secret))
                    .withClaim("token_type", "access")
                    .build()
                    .verify(token);
            return ResponseEntity.ok(tokenFactory.generateTokens(id));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
    }
}
