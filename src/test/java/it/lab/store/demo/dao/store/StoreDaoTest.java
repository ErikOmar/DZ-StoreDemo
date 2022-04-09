package it.lab.store.demo.dao.store;

import it.lab.store.demo.model.store.StoreDto;
import it.lab.store.demo.model.store.StoreEntity;
import it.lab.store.demo.util.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class StoreDaoTest {

    @Autowired
    private StoreDao storeDao;

    private StoreDto storeDto;


    @Test
    public void testFindByStoreId() {

    }

    @Test
    public void testGetStores() {
        List<StoreEntity> storeList = storeDao.findAll();
        assertNotNull(storeList, "La lista debe regresar artículos");
        assertFalse(storeList.isEmpty(), "La lista no debe estar vacia");
    }

    @Test
    public void testAddStore(){
        ApiResponse<StoreEntity> result = new ApiResponse<>();

        StoreEntity storeEntity = getStoreEntity();

        boolean isAdded = true;
        storeDao.add(storeEntity);
        result.setElement(storeEntity);

        assertFalse(!isAdded, "The store could not be added");
    }

    private StoreEntity getStoreEntity(){
        storeDto = new StoreDto();

        storeDto.setAddresss("Main St");
        storeDto.setAddressNumber("7777");
        storeDto.setNeightborhood("Happy Place");
        storeDto.setPostalCode("78723");
        storeDto.setState("New Happy");

        StoreEntity storeEntity = StoreEntity.create(storeDto);
        storeEntity.setStoreId("TEST0002");

        return storeEntity;
    }

}
