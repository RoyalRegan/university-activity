package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hibernate.HibernateHandler;
import hibernate.dao.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import utils.Checker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.security.Key;
import java.util.Base64;
import java.util.List;

@WebServlet("/api/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        final JsonObject report = new JsonObject();
        final Writer writer = resp.getWriter();
        final String inputToken = req.getHeader("token");
        final JsonObject jsonObject = new Gson().fromJson(req.getReader(), JsonObject.class);
        if (jsonObject!=null&&jsonObject.has("pas")) {
            if (inputToken != null) {
                final String payload = inputToken.subSequence(inputToken.indexOf('.') + 1, inputToken.lastIndexOf('.')).toString();
                final String payloadJson = new String(Base64.getDecoder().decode(payload));
                if (Checker.isJSONValid(payloadJson)) {
                    final JsonObject decodedPayload = new Gson().fromJson(payloadJson, JsonObject.class);
                    if (decodedPayload.has("jti")) {
                        final UserEntity userEntity = HibernateHandler.getEntity(UserEntity.class, decodedPayload.get("jti").getAsInt());
                        if (userEntity != null) {
                            final Key key = Keys.hmacShaKeyFor(userEntity.getSecret());
                            final String tokenFromBase = Jwts.builder().setId(Integer.toString(userEntity.getId())).signWith(key).compact();
                            final String userPas = userEntity.getPassword();
                            if (tokenFromBase.equals(inputToken) && userPas.equals(jsonObject.get("pas").getAsString())) {
                                if (jsonObject.get("newLog") != null) {
                                    userEntity.setLogin(jsonObject.get("newLog").getAsString());
                                }
                                if (jsonObject.get("newPas") != null) {
                                    userEntity.setPassword(jsonObject.get("newPas").getAsString());
                                }
                                if (jsonObject.get("newName") != null) {
                                    userEntity.setName(jsonObject.get("newName").getAsString());
                                }
                                HibernateHandler.updateEntity(userEntity);
                                report.addProperty("message", "User data updated");
                            } else {
                                resp.setStatus(HttpServletResponse.SC_CONFLICT);
                                report.addProperty("message", "Access denied");
                            }
                        } else {
                            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                            report.addProperty("message", "Wrong token");
                        }
                    } else {
                        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        report.addProperty("message", "Wrong token");
                    }
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    report.addProperty("message", "Wrong token");
                }
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                report.addProperty("message", "Token is missing");
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            report.addProperty("message", "Wrong Json");
        }
        report.addProperty("status", resp.getStatus());
        writer.write(report.toString());
        writer.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        final JsonObject report = new JsonObject();
        final Writer writer = resp.getWriter();
        final String inputToken = req.getHeader("token");
        final JsonObject jsonObject = new Gson().fromJson(req.getReader(), JsonObject.class);
        if (jsonObject != null && jsonObject.has("pas")) {
            if (inputToken != null) {
                final String payload = inputToken.subSequence(inputToken.indexOf('.') + 1, inputToken.lastIndexOf('.')).toString();
                final String payloadJson = new String(Base64.getDecoder().decode(payload));
                if (Checker.isJSONValid(payloadJson)) {
                    final JsonObject decodedPayload = new Gson().fromJson(payloadJson, JsonObject.class);
                    if (decodedPayload.has("jti")) {
                        final UserEntity userEntity = HibernateHandler.getEntity(UserEntity.class, decodedPayload.get("jti").getAsInt());
                        if (userEntity != null) {
                            final Key key = Keys.hmacShaKeyFor(userEntity.getSecret());
                            final String tokenFromBase = Jwts.builder().setId(Integer.toString(userEntity.getId())).signWith(key).compact();
                            final String userPas = userEntity.getPassword();
                            if (tokenFromBase.equals(inputToken) && userPas.equals(jsonObject.get("pas").getAsString())) {
                                if (HibernateHandler.deleteEntity(userEntity)) {
                                    report.addProperty("message", "User deleted");
                                }
                            } else {
                                resp.setStatus(HttpServletResponse.SC_CONFLICT);
                                report.addProperty("message", "Access denied");
                            }
                        } else {
                            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                            report.addProperty("message", "Wrong token");
                        }
                    } else {
                        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        report.addProperty("message", "Wrong token");
                    }
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    report.addProperty("message", "Wrong token");
                }
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                report.addProperty("message", "Token is missing");
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            report.addProperty("message", "Wrong Json");
        }
        report.addProperty("status", resp.getStatus());
        writer.write(report.toString());
        writer.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        final JsonObject report = new JsonObject();
        final Writer writer = resp.getWriter();
        final List<UserEntity> userEntities = HibernateHandler.getEntitys(UserEntity.class);
        if (userEntities != null) {
            JsonElement jsonElement = new JsonParser().parse(new Gson().toJson(userEntities));
            report.add("users", jsonElement);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        report.addProperty("status", resp.getStatus());
        writer.write(report.toString());
        writer.flush();
    }
}

