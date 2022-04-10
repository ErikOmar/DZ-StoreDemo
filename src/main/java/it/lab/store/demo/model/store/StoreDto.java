package it.lab.store.demo.model.store;

public class StoreDto {

    /**
     * address represents  the street, avenue, ect where the store is located
     * this field doesn't include the address number.
     */
    private String address;

    /**
     * address_number represents stores the number of the address where the street is located
     */
    private String  addressNumber;

    /**
     * neightborhood represents the neighborhood where the store is located
     */
    private String neightborhood;

    /**
     * postal_code represents the neighborhood where the store is located
     */
    private String postalCode;

    /**
     * state represents the state where the store is located
     */
    private String state;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%s] address: %s, addressNumber: %s neightborhood: %s, postalCode: %s, state: %s",
                getClass().getSimpleName(),
                address,
                addressNumber,
                neightborhood,
                postalCode,
                state);
    }
}
