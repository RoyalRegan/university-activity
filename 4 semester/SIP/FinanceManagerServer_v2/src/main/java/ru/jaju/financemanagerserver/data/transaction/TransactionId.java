package ru.jaju.financemanagerserver.data.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
public class TransactionId implements Serializable {
    @JsonProperty("transaction_id")
    @Column(name = "id")
    private String transId;

    @JsonProperty("user_id")
    @JoinColumn(name = "user_id")
    private int userId;
}
