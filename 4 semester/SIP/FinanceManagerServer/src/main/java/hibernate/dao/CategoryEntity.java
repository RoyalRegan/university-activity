package hibernate.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "sql7281126", catalog = "")
public class CategoryEntity {
    private int id;
    private String name;
    private Timestamp dateCreated;
    private String vColorHex;
    private Short vIconId;
    private Integer vListOrder;
    private Byte isDeleted;

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
    @Column(name = "name", nullable = false, length = 70)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "date_created")
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "v_color_hex", length = -1)
    public String getvColorHex() {
        return vColorHex;
    }

    public void setvColorHex(String vColorHex) {
        this.vColorHex = vColorHex;
    }

    @Basic
    @Column(name = "v_icon_id")
    public Short getvIconId() {
        return vIconId;
    }

    public void setvIconId(Short vIconId) {
        this.vIconId = vIconId;
    }

    @Basic
    @Column(name = "v_list_order")
    public Integer getvListOrder() {
        return vListOrder;
    }

    public void setvListOrder(Integer vListOrder) {
        this.vListOrder = vListOrder;
    }

    @Basic
    @Column(name = "is_deleted")
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (id != that.id) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(dateCreated, that.dateCreated)) return false;
        if (!Objects.equals(vColorHex, that.vColorHex)) return false;
        if (!Objects.equals(vIconId, that.vIconId)) return false;
        if (!Objects.equals(vListOrder, that.vListOrder)) return false;
        return Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (vColorHex != null ? vColorHex.hashCode() : 0);
        result = 31 * result + (vIconId != null ? vIconId.hashCode() : 0);
        result = 31 * result + (vListOrder != null ? vListOrder.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }
}
