package it.lab.store.demo.services;

import it.lab.store.demo.dao.store.StoreDao;
import it.lab.store.demo.model.store.StoreDto;
import it.lab.store.demo.model.store.StoreEntity;
import it.lab.store.demo.util.ApiMessage;
import it.lab.store.demo.util.ApiResponse;
import it.lab.store.demo.util.ApiResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StoreService {

    @Autowired
    private StoreDao storeDao;

    public ApiResponseList<StoreEntity> getStores() {
        ApiResponseList<StoreEntity> result = new ApiResponseList<>(new ArrayList<>());
        try {
            List<StoreEntity> storeList = storeDao.findAll();
            result.setList(storeList);
        } catch (DataAccessException dae) {
            result.addMessage(ApiMessage.MessageType.Error, "There is a problem reading data from the database");
        }
        return result;
    }

    public ApiResponse<StoreEntity> add(StoreDto storeDto) {
        ApiResponse<StoreEntity> result = new ApiResponse<>();
        try {
            StoreEntity storeEntity = StoreEntity.create(storeDto);
            storeEntity.setStoreId(generateStoreId());

            storeDao.add(storeEntity);
            result.setElement(storeEntity);
        } catch (DataIntegrityViolationException dae) {
            result.addMessage(ApiMessage.MessageType.Error, "There is a problem adding data to the database");
        }

        return result;
    }

    public String generateStoreId() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public ApiResponse<StoreEntity> edit(StoreDto storeDto, String storeId) {
        ApiResponse<StoreEntity> result = new ApiResponse<>();
        try {
            StoreEntity storeEntity = storeDao.update(storeDto, storeId);
            result.setElement(storeEntity);
        } catch (DataAccessException dae) {
            result.addMessage(ApiMessage.MessageType.Error, "There is a problem updating data to the database");
        }

        return result;
    }

    public ApiResponse<StoreEntity> remove(String storeId) {
        ApiResponse<StoreEntity> result = new ApiResponse<>();
        try {

            StoreEntity storeEntity = storeDao.findStore(storeId);
            if( storeEntity == null){
                result.addMessage(ApiMessage.MessageType.Error, "The store does not exist");
            } else {
                storeDao.delete(storeId);
            }

            result.setElement(storeEntity);
        } catch (DataAccessException dae) {
            result.addMessage(ApiMessage.MessageType.Error, "There is a problem deleting data to the database");
        }

        return result;
    }

}
