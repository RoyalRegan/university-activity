package ru.jaju.financemanagerserver.security.filter;

import com.google.gson.Gson;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.jaju.financemanagerserver.data.user.User;
import ru.jaju.financemanagerserver.security.UserDataHandler;
import ru.jaju.financemanagerserver.util.TokenFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private TokenFactory tokenFactory;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, TokenFactory tokenFactory) {
        this.authenticationManager = authenticationManager;
        this.tokenFactory = tokenFactory;
        setFilterProcessesUrl("/api/authentication");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            User user = new Gson().fromJson(req.getReader(), User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getLogin(),
                            user.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        UserDataHandler user = (UserDataHandler) auth.getPrincipal();
        res.setContentType("application/json");
        res.getWriter().write(tokenFactory.generateTokens(user.getId()));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}