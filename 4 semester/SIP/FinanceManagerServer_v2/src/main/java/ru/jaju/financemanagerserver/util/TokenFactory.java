package ru.jaju.financemanagerserver.util;

import com.auth0.jwt.JWT;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.jaju.financemanagerserver.data.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

//TODO Change TokenFactory (?)

@Component
public class TokenFactory {
    private final UserRepository userRepository;

    @Autowired
    public TokenFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateTokens(int id) {
        Date accessExpireIn = Date.from(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.UTC));
        Date refreshExpireIn = Date.from(LocalDateTime.now().plusMonths(1).toInstant(ZoneOffset.UTC));
        String accessToken = JWT.create()
                .withSubject(Integer.toString(id))
                .withExpiresAt(accessExpireIn)
                .withClaim("token_type", "access")
                .sign(HMAC512(userRepository.findById(id).get().getSecret()));
        String refreshToken = JWT.create()
                .withSubject(Integer.toString(id))
                .withExpiresAt(refreshExpireIn)
                .withClaim("token_type", "refresh")
                .sign(HMAC512(userRepository.findById(id).get().getSecret()));

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("accessToken", accessToken);
        jsonObject.addProperty("access_expire_in", accessExpireIn.getTime());
        jsonObject.addProperty("refreshToken", refreshToken);
        jsonObject.addProperty("refresh_expire_in", refreshExpireIn.getTime());
        return jsonObject.toString();
    }
}
