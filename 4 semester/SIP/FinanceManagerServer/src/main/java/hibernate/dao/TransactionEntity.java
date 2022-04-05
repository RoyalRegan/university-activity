package hibernate.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "transaction", schema = "sql7281126", catalog = "")
public class TransactionEntity {
    private int id;
    private String type;
    private Timestamp datetime;
    private Integer amount;
    private String description;
    private Timestamp dateCreated;
    private AssetEntity assetByAssetId;
    private CategoryEntity categoryByCategoryId1;
    private CurrencyEntity currencyByCurrencyId1;

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
    @Column(name = "type", nullable = false, length = -1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "datetime", nullable = false)
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "description", length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "date_created")
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (id != that.id) return false;
        if (!Objects.equals(type, that.type)) return false;
        if (!Objects.equals(datetime, that.datetime)) return false;
        if (!Objects.equals(amount, that.amount)) return false;
        if (!Objects.equals(description, that.description)) return false;
        return Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "id", nullable = false)
    public AssetEntity getAssetByAssetId() {
        return assetByAssetId;
    }

    public void setAssetByAssetId(AssetEntity assetByAssetId) {
        this.assetByAssetId = assetByAssetId;
    }

    @ManyToOne
    @JoinColumn(name = "category_id1", referencedColumnName = "id", nullable = false)
    public CategoryEntity getCategoryByCategoryId1() {
        return categoryByCategoryId1;
    }

    public void setCategoryByCategoryId1(CategoryEntity categoryByCategoryId1) {
        this.categoryByCategoryId1 = categoryByCategoryId1;
    }

    @ManyToOne
    @JoinColumn(name = "currency_id1", referencedColumnName = "id")
    public CurrencyEntity getCurrencyByCurrencyId1() {
        return currencyByCurrencyId1;
    }

    public void setCurrencyByCurrencyId1(CurrencyEntity currencyByCurrencyId1) {
        this.currencyByCurrencyId1 = currencyByCurrencyId1;
    }
}
