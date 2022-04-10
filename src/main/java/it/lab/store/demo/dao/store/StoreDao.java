package it.lab.store.demo.dao.store;

import it.lab.store.demo.model.store.StoreDto;
import it.lab.store.demo.model.store.StoreEntity;

import java.util.List;

public interface StoreDao {

    List<StoreEntity> findAll();
    StoreEntity findStore(String storeId);
    boolean add(StoreEntity store);
    boolean update(StoreDto store, String storeId);
    boolean delete(String storeId);

}
