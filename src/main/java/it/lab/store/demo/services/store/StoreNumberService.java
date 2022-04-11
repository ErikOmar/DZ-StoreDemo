package it.lab.store.demo.services.store;

import it.lab.store.demo.dao.store.StoreNumberDao;
import it.lab.store.demo.model.store.StoreNumberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreNumberService {

    @Autowired
    private StoreNumberDao storeNumberDao;

    /**
     * Generates the identifier to assign a new store
     * @return String with the generated store Id
     */
    public String GetNextStoreId() {
        int currentStoreNumber;

        StoreNumberEntity storeNumberEntity = storeNumberDao.findById(1).get();
        currentStoreNumber = storeNumberEntity.getStoreNumber();
        storeNumberEntity.setStoreNumber(currentStoreNumber+1);
        storeNumberDao.save(storeNumberEntity);

        return GenerateStoreId(currentStoreNumber);

    }

    private String GenerateStoreId(int nextStoreId) {

        return String.format("%s%05d",
                "STR",
                nextStoreId);

    }
}
