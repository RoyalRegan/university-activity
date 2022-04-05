package hibernate.dao;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "budget", schema = "sql7281126", catalog = "")
public class BudgetEntity {
    private int id;
    private String name;
    private String interval;
    private int amount;
    private byte isAll;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "interval", nullable = false, length = -1)
    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    @Basic
    @Column(name = "amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "is_all", nullable = false)
    public byte getIsAll() {
        return isAll;
    }

    public void setIsAll(byte isAll) {
        this.isAll = isAll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BudgetEntity that = (BudgetEntity) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        if (isAll != that.isAll) return false;
        if (!Objects.equals(name, that.name)) return false;
        return Objects.equals(interval, that.interval);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (interval != null ? interval.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (int) isAll;
        return result;
    }
}
