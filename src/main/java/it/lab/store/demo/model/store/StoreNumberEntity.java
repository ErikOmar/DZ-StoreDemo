package it.lab.store.demo.model.store;

import javax.persistence.*;

@Entity
@Table(name = "store_number")
public class StoreNumberEntity {

    /**
     * store_number_id stores a primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_number_id", nullable = false, unique = true, updatable = false)
    private Integer storeNumberId;

    /**
     * storeNumber stores the next value to assign a new store.
     */
    @Column(name = "store_number", nullable = false)
    private Integer storeNumber;

    public Integer getStoreNumberId() {
        return storeNumberId;
    }

    public void setStoreNumberId(Integer storeNumberId) {
        this.storeNumberId = storeNumberId;
    }

    public Integer getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Integer storeNumber) {
        this.storeNumber = storeNumber;
    }
}
