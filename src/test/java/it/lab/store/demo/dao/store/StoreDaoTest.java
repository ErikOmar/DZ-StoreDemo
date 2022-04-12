package it.lab.store.demo.dao.store;

import it.lab.store.demo.TestData.StoreData;
import it.lab.store.demo.model.store.StoreEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class StoreDaoTest {

    /**
     * Tests to evaluate the CRUD operations on the database are correct
     */

    @Autowired
    private StoreDao storeDao;



    @Test
    public void testFindByStoreId() {
        StoreEntity storeEntity = storeDao.findStore(StoreData.getStoreId());
        assertNotNull(storeEntity, "The store couldn't be find");
    }

    @Test
    public void testGetStores() {
        List<StoreEntity> storeList = storeDao.findAll();
        assertNotNull(storeList, "The list must return values");
        assertFalse(storeList.isEmpty(), "The list must not be empty");
    }

    @Test
    public void testAddStore(){

        StoreEntity storeEntity = StoreData.getStoreEntity();
        boolean isAdded = storeDao.add(storeEntity);
        assertFalse(!isAdded, "The store could not be added");


        String storeId = storeEntity.getStoreId();
        storeEntity = storeDao.findStore(storeId);
        assertNotNull(storeEntity, "The store could not be added, as expected");
    }


    @Test
    public void testModifyStore(){


        boolean isEditted = storeDao.update(StoreData.getStoreDto(), StoreData.getStoreId());
        assertFalse(!isEditted, "The store could not be modified");

        StoreEntity storeEntity = StoreEntity.create(StoreData.getStoreDto());
        storeEntity.setStoreId(StoreData.getStoreId());
        StoreEntity storeEntityUpdated = storeDao.findStore(StoreData.getStoreId());
        boolean isDataUpdated = checkIfIsUpdated(storeEntity, storeEntityUpdated);
        assertFalse(!isDataUpdated, "The store fields could not be modified as expected");
    }



    private boolean checkIfIsUpdated(StoreEntity actualEntity, StoreEntity updatedEntity){
        boolean isUpdated = true;

        if (!actualEntity.getAddress().equals(updatedEntity.getAddress())) isUpdated = false;
        if (!actualEntity.getAddressNumber().equals(updatedEntity.getAddressNumber())) isUpdated = false;
        if (!actualEntity.getNeightborhood().equals(updatedEntity.getNeightborhood())) isUpdated = false;
        if (!actualEntity.getPostalCode().equals(updatedEntity.getPostalCode())) isUpdated = false;
        if (actualEntity.getLastUpdateDate().equals(updatedEntity.getLastUpdateDate())) isUpdated = false;
        if (!actualEntity.getState().equals(updatedEntity.getState())) isUpdated = false;

        return isUpdated;
    }

    @Test
    public void testRemovedStore(){
        String _storeId = "STR00001";

        boolean isRemoved = storeDao.delete(_storeId);
        assertFalse(!isRemoved, "The store could not be removed");

        StoreEntity storeEntity = storeDao.findStore(_storeId);
        assertNull(storeEntity, "The store could not be removed");
    }

}
