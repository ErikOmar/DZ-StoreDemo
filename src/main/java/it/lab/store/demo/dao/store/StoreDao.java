package it.lab.store.demo.dao.store;

import it.lab.store.demo.model.store.StoreDto;
import it.lab.store.demo.model.store.StoreEntity;

import java.util.List;

public interface StoreDao {

    List<StoreEntity> findAll();
    StoreEntity findStore(String storeId);
    StoreEntity add(StoreEntity store);
    StoreEntity update(StoreDto store, String storeId);
    StoreEntity delete(String storeId);

}
