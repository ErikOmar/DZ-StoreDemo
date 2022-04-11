package it.lab.store.demo.dao.store;

import it.lab.store.demo.model.store.StoreNumberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreNumberDao extends CrudRepository<StoreNumberEntity, Integer> {

}
