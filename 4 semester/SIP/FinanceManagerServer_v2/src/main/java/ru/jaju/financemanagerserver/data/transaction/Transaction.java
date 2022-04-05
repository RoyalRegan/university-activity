package ru.jaju.financemanagerserver.data.transaction;

import com.fasterxml.jackson.annotation.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PUBLIC, force=true)
@Table(name = "transaction")
public class Transaction {
    @JsonProperty("id")
    @EmbeddedId
    private TransactionId transactionId;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "note")
    private String note;

    @JsonProperty("ignore_time")
    @Column(name = "ignore_time")
    private Boolean ignoreTime;

    @JsonProperty("date_time")
    @Column(name = "date_time", nullable = false)
    private Timestamp dateTime;

    @JsonProperty("last_updated")
    @Column(name = "last_updated", nullable = false)
    private Timestamp lastUpdate;

    @JsonProperty("category_id")
    @Column(name = "category_id")
    private String categoryId;

    @PrePersist
    private void onCreate() {
        this.lastUpdate = new Timestamp(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).getTime());
    }

    @PreUpdate
    private void onUpdate() {
        this.lastUpdate = new Timestamp(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).getTime());
    }
}
