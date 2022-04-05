package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import hibernate.HibernateHandler;
import hibernate.dao.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.security.Key;
import java.sql.Timestamp;

@WebServlet("/api/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        final JsonObject report = new JsonObject();
        final Writer writer = resp.getWriter();
        final UserEntity user = new Gson().fromJson(req.getReader(), UserEntity.class);
        if (user != null && user.getLogin() != null && user.getPassword() != null) {
            final Timestamp dataJoin = new Timestamp(System.currentTimeMillis());
            final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
            user.setDateJoined(dataJoin);
            user.setSecret(key.getEncoded());
            if (HibernateHandler.addEntity(user)) {
                final String token = Jwts.builder().setId(Integer.toString(user.getId())).signWith(key).compact();
                resp.setHeader("token", token);
                report.addProperty("message", "User registered");
            } else {
                resp.setStatus(HttpServletResponse.SC_CONFLICT);
                report.addProperty("message", "Login already taken");
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            report.addProperty("message", "Wrong Json");
        }
        report.addProperty("status", resp.getStatus());
        writer.write(report.toString());
        writer.flush();
    }
}
