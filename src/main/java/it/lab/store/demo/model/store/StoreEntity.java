package it.lab.store.demo.model.store;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "store")
public class StoreEntity implements Serializable {

    // char(8)
    @Id
    @Column(name = "store_id", nullable = false, unique = true, updatable = false, length = 8)
    private String storeId;

    // varchar(100)
    @Column(name = "addresss", nullable = false, length = 100)
    private String addresss;

    // varchar(8)
    @Column(name = "address_number", nullable = false, length = 8)
    private String  addressNumber;

    // varchar(60)
    @Column(name = "neightborhood", nullable = false, length = 60)
    private String neightborhood;

    // varchar(9)
    @Column(name = "postal_code", nullable = false, length = 9)
    private String postalCode;

    // timestamp
    @Column(name = "last_update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;

    // varchar(30)
    @Column(name = "state", nullable = false, length = 30)
    private String state;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getNeightborhood() {
        return neightborhood;
    }

    public void setNeightborhood(String neightborhood) {
        this.neightborhood = neightborhood;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%s] storeId: %s, address: %s, addressNumber: %s neightborhood: %s, postalCode: %s, lastUpdateDate: %s, state: %s",
                getClass().getSimpleName(),
                storeId,
                addresss,
                addressNumber,
                neightborhood,
                postalCode,
                state);
    }

    /**
     * Create a StoreEntity with the user input
     * @param storeDto
     * @return
     */
    public static StoreEntity create(StoreDto storeDto){
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresss(storeDto.getAddresss());
        storeEntity.setAddressNumber(storeDto.getAddressNumber());
        storeEntity.setNeightborhood(storeDto.getNeightborhood());
        storeEntity.setPostalCode(storeDto.getPostalCode());
        storeEntity.setLastUpdateDate(new Date());
        storeEntity.setState(storeDto.getState());

        return storeEntity;
    }

}
