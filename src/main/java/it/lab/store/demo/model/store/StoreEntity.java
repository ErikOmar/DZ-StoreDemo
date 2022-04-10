package it.lab.store.demo.model.store;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "store")
public class StoreEntity implements Serializable {


    /**
     * store_id stores a unique calculated char(8) to identify the store
     */
    @Id
    @Column(name = "store_id", nullable = false, unique = true, updatable = false, length = 8)
    private String storeId;

    /**
     * address stores a varchar(100) representing the street, avenue, ect where the store is located
     * this field doesn't include the address number.
     */
    @Column(name = "addresss", nullable = false, length = 100)
    private String addresss;

    /**
     * address_number a varchar(8) representing stores the number of the address where the street is located
     */
    @Column(name = "address_number", nullable = false, length = 8)
    private String  addressNumber;

    /**
     * neightborhood stores a varchar(60) representing the neighborhood where the store is located
     */
    @Column(name = "neightborhood", nullable = false, length = 60)
    private String neightborhood;

    /**
     * postal_code stores a varchar(9) representing the neighborhood where the store is located
     */
    @Column(name = "postal_code", nullable = false, length = 9)
    private String postalCode;

    /**
     * lastUpdateDate stores a timestamp with the date and time of the last change
     */
    @Column(name = "last_update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;

    /**
     * state stores a varchar(30) representing the state where the store is located
     */
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
        return String.format("%s] storeId: %s, address: %s, addressNumber: %s, neightborhood: %s, postalCode: %s, lastUpdateDate: %s, state: %s",
                getClass().getSimpleName(),
                storeId,
                addresss,
                addressNumber,
                neightborhood,
                postalCode,
                lastUpdateDate,
                state);
    }

    /**
     * Create a StoreEntity with the user input
     * @param storeDto
     * @return
     */
    public static StoreEntity create(StoreDto storeDto){
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresss(storeDto.getAddress());
        storeEntity.setAddressNumber(storeDto.getAddressNumber());
        storeEntity.setNeightborhood(storeDto.getNeightborhood());
        storeEntity.setPostalCode(storeDto.getPostalCode());
        storeEntity.setLastUpdateDate(new Date());
        storeEntity.setState(storeDto.getState());

        return storeEntity;
    }

}
