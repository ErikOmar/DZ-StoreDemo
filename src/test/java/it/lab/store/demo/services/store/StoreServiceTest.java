package it.lab.store.demo.services.store;

import it.lab.store.demo.TestData.StoreData;
import it.lab.store.demo.model.store.StoreDto;
import it.lab.store.demo.model.store.StoreEntity;
import it.lab.store.demo.util.ApiResponse;
import it.lab.store.demo.util.ApiResponseList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class StoreServiceTest {

    /**
     * Tests to evaluate that the response object has the values it should have.
     */


    @Autowired
    private StoreService storeService;

    @Test
    public void testGetStores() {

        ApiResponseList<StoreEntity> result = storeService.getStores();
        assertNotNull(result.getList(), "The list must return values");
        assertNotNull(result.getListMessages(), "The error list must return values");

        boolean isEmptyListMessages = true;
        if(result.getListMessages() != null){
            isEmptyListMessages = result.getListMessages().isEmpty();
        }
        assertFalse( isEmptyListMessages, "The error list must return values");

    }

    @Test
    public void testAdd() {
        ApiResponse<StoreEntity> result = storeService.add(StoreData.getStoreDto());
        assertNotNull(result.getElement(), "Element must return value");

        boolean isEmptyListMessages = true;
        if(result.getListMessages() != null){
            isEmptyListMessages = result.getListMessages().isEmpty();
        }
        assertFalse( isEmptyListMessages, "The error list must return values");
    }



    @Test
    public void testEdit() {
        ApiResponse<StoreEntity> result = storeService.edit(StoreData.getStoreDto(), StoreData.getStoreId());
        assertNotNull(result.getElement(), "Element must return value");

        boolean isEmptyListMessages = true;
        if(result.getListMessages() != null){
            isEmptyListMessages = result.getListMessages().isEmpty();
        }
        assertFalse( isEmptyListMessages, "The error list must return values");
    }

    @Test
    public void testGetRevome() {
        ApiResponse<StoreEntity> result = storeService.remove(StoreData.getStoreId());
        assertNotNull(result.getElement(), "Element must return value");

        boolean isEmptyListMessages = true;
        if(result.getListMessages() != null){
            isEmptyListMessages = result.getListMessages().isEmpty();
        }
        assertFalse( isEmptyListMessages, "The error list must return values");
    }
}
