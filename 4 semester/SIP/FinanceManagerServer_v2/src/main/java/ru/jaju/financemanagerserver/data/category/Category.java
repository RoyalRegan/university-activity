package ru.jaju.financemanagerserver.data.category;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "category")

public class Category {
    @JsonProperty("id")
    @EmbeddedId
    private CategoryId categoryId;

    @Column(name = "type", nullable = false)
    private byte type;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonProperty("list_order")
    @Column(name = "list_order", nullable = false)
    private int listOrder;

    @Column(name = "color", nullable = false)
    private int color;

    @Column(name = "icon", nullable = false)
    private int icon;

    @JsonProperty("last_updated")
    @Column(name = "last_updated", nullable = false)
    private Timestamp lastUpdate;

    @PrePersist
    private void onCreate() {
        this.lastUpdate = new Timestamp(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).getTime());
    }

    @PreUpdate
    private void onUpdate() {
        this.lastUpdate = new Timestamp(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).getTime());
    }
}