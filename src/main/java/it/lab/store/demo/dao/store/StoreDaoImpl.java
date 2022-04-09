package it.lab.store.demo.dao.store;

import it.lab.store.demo.model.store.StoreDto;
import it.lab.store.demo.model.store.StoreEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Repository
public class StoreDaoImpl implements StoreDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<StoreEntity> findAll(){
        return em.createQuery("from StoreEntity").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public StoreEntity findStore(String storeId){
        return em.find(StoreEntity.class, storeId);
    }

    @Override
    @Transactional
    public StoreEntity add(StoreEntity storeEntity){
        em.persist(storeEntity);
        return storeEntity;
    }

    @Override
    @Transactional
    public StoreEntity update(StoreDto store, String storeId) {
        StoreEntity storeEntity = findStore(storeId);

        storeEntity.setAddresss(store.getAddresss());
        storeEntity.setAddressNumber( store.getAddressNumber());
        storeEntity.setNeightborhood(store.getNeightborhood());
        storeEntity.setPostalCode(store.getPostalCode());
        storeEntity.setLastUpdateDate(new Date());
        storeEntity.setState(store.getState());

        em.merge(storeEntity);
        return storeEntity;
    }

    @Override
    @Transactional
    public StoreEntity delete(String storeId) {
        StoreEntity storeEntity = findStore(storeId);
        em.remove(storeEntity);
        return storeEntity;
    }


}
