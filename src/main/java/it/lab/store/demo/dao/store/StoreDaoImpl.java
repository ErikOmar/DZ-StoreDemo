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

    /**
     * Get all the stores from the stores table
     * @return List<StoreEntity> with the list of all stores
     */
    @Transactional(readOnly = true)
    @Override
    public List<StoreEntity> findAll(){
        return em.createQuery("from StoreEntity").getResultList();
    }

    /**
     * Get a store by the store identifier
     * @param storeId The id of the store to find
     * @return the store by matching name.
     */
    @Override
    @Transactional(readOnly = true)
    public StoreEntity findStore(String storeId){
        return em.find(StoreEntity.class, storeId);
    }

    /**
     * Add new store to the table stores.
     * @param storeEntity representing the store to insert into the table.
     * @return the identity inserted.
     */
    @Override
    @Transactional
    public boolean add(StoreEntity storeEntity){
        try {
            em.persist(storeEntity);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    /**
     * Update an existing store.
     * @param store The values to update the store.
     * @param storeId the value of the store to update.
     * @return the identity updated.
     */
    @Override
    @Transactional
    public boolean update(StoreDto store, String storeId) {

        try {
            StoreEntity storeEntity = findStore(storeId);

            storeEntity.setAddresss(store.getAddress());
            storeEntity.setAddressNumber( store.getAddressNumber());
            storeEntity.setNeightborhood(store.getNeightborhood());
            storeEntity.setPostalCode(store.getPostalCode());
            storeEntity.setLastUpdateDate(new Date());
            storeEntity.setState(store.getState());

            em.merge(storeEntity);
            return true;
        } catch (Exception ex){
            return false;
        }

    }

    /**
     * Remove an existing store.
     * @param storeId The values of the store to remove.
     * @return  the identity deleted.
     */
    @Override
    @Transactional
    public boolean delete(String storeId) {
        try {
            StoreEntity storeEntity = findStore(storeId);
            em.remove(storeEntity);
            return true;
        } catch (Exception ex){
            return false;
        }

    }


}
