package it.lab.store.demo.TestData;

import it.lab.store.demo.model.store.StoreDto;
import it.lab.store.demo.model.store.StoreEntity;

public class StoreData {

    private static StoreDto storeDto;
    private static String storeId = "STR00002";


    public static String getStoreId() {
        return storeId;
    }

    public static StoreEntity getStoreEntity(){
        storeDto = new StoreDto();

        storeDto.setAddress("Main St");
        storeDto.setAddressNumber("7777");
        storeDto.setNeightborhood("Happy Place");
        storeDto.setPostalCode("78723");
        storeDto.setState("New Happy");

        StoreEntity storeEntity = StoreEntity.create(storeDto);
        storeEntity.setStoreId("TEST0002");

        return storeEntity;
    }

    public static StoreDto getStoreDto(){
        storeDto = new StoreDto();

        storeDto.setAddress("Central Ave");
        storeDto.setAddressNumber("1111");
        storeDto.setNeightborhood("Chinesse");
        storeDto.setPostalCode("23423");
        storeDto.setState("LAX");

        return storeDto;
    }

}
