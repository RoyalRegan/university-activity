package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import hibernate.HibernateHandler;
import hibernate.dao.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.security.Key;

@WebServlet("/api/authentication")
public class AuthenticationServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        final JsonObject report = new JsonObject();
        final Writer writer = resp.getWriter();
        final JsonObject jsonObject = new Gson().fromJson(req.getReader(), JsonObject.class);
        if (jsonObject != null && jsonObject.has("log") && jsonObject.has("pas")) {
            final String userLogin = jsonObject.get("log").getAsString();
            final String userPass = jsonObject.get("pas").getAsString();
            final UserEntity userEntity = HibernateHandler.getUserByLogin(userLogin);
            if (userEntity != null && userEntity.getPassword().equals(userPass)) {
                final Key key = Keys.hmacShaKeyFor(userEntity.getSecret());
                final String token = Jwts.builder().setId(Integer.toString(userEntity.getId())).signWith(key).compact();
                resp.setHeader("token", token);
                report.addProperty("message", "Authorized");
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                report.addProperty("message", "Incorrect login or password");
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
