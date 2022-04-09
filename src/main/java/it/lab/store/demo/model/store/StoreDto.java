package it.lab.store.demo.model.store;

public class StoreDto {

    private String addresss;

    private String  addressNumber;

    private String neightborhood;

    private String postalCode;

    private String state;

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
                addresss,
                addressNumber,
                neightborhood,
                postalCode,
                state);
    }
}
