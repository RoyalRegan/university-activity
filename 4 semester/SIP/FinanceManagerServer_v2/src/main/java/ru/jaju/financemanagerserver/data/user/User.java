package ru.jaju.financemanagerserver.data.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Empty login")
    @Length(min = 5, max = 20, message = "Login length must be between 5 and 20 characters")
    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @NotNull(message = "Empty password")
    @NotBlank(message = "Empty password")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull(message = "Empty balance")
    @Column(name = "balance", nullable = false)
    private int balance;

    @JsonProperty("date_joined")
    @Column(name = "date_joined", nullable = false)
    private Timestamp dateJoined;

    @Column(name = "secret", nullable = false)
    private byte[] secret;

    @PrePersist
    void onCreate() {
        this.dateJoined = new Timestamp(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).getTime());
        this.secret = Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded();
    }
}
