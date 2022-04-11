package it.lab.store.demo.services.store;

import it.lab.store.demo.dao.store.StoreDao;
import it.lab.store.demo.model.store.StoreDto;
import it.lab.store.demo.model.store.StoreEntity;
import it.lab.store.demo.model.store.util.ApiMessage;
import it.lab.store.demo.model.store.util.ApiResponse;
import it.lab.store.demo.model.store.util.ApiResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StoreService {

    @Autowired
    private StoreDao storeDao;

    /**
     * Get the list of all stores.
     * @return object with the list of all stores, an attribute if any error exists, and a list with messages
     * to represent the result of the request.
     */
    public ApiResponseList<StoreEntity> getStores() {
        ApiResponseList<StoreEntity> result = new ApiResponseList<>(new ArrayList<>());
        try {
            List<StoreEntity> storeList = storeDao.findAll();
            result.setList(storeList);
            result.addMessage(ApiMessage.MessageType.Success,
                    "The list of stores has been obtained successfully");
        } catch (DataAccessException dae) {
            result.addMessage(ApiMessage.MessageType.Error, "There is a problem reading data from the database");
        }
        return result;
    }

    /**
     * Add new store to the table stores.
     * @param storeDto representing the values of the store to add.
     * @return object with the store added, an attribute if any error exists, and a list with messages
     * to represent the result of the request.
     */
    public ApiResponse<StoreEntity> add(StoreDto storeDto) {
        ApiResponse<StoreEntity> result = new ApiResponse<>();
        try {

            if(!isValidStore(storeDto, result)){
                return result;
            }

            StoreEntity storeEntity = StoreEntity.create(storeDto);
            storeEntity.setStoreId(generateStoreId());

            storeDao.add(storeEntity);
            result.setElement(storeEntity);
            result.addMessage(ApiMessage.MessageType.Success,
                    "Store has been created successfully");
        } catch (DataIntegrityViolationException dae) {
            result.addMessage(ApiMessage.MessageType.Error, "There is a problem adding data to the database");
        }

        return result;
    }

    /**
     * Generate a random string to represent the identifier of the store.
     * @return a 8 string long to identifier a store.
     */
    private String generateStoreId() {
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


    /**
     * Modify the values of an existing store.
     * @param storeDto representing the values of the store to modify.
     * @param storeId the value of the store to modify.
     * @return object with the store modified, an attribute if any error exists, and a list with messages
     * to represent the result of the request.
     */
    public ApiResponse<StoreEntity> edit(StoreDto storeDto, String storeId) {
        ApiResponse<StoreEntity> result = new ApiResponse<>();
        try {

            if(!isValidStore(storeDto, result)){
                return result;
            }

            storeDao.update(storeDto, storeId);
            StoreEntity storeEntity = StoreEntity.create(storeDto);
            storeEntity.setStoreId(storeId);
            result.setElement(storeEntity);
            result.addMessage(ApiMessage.MessageType.Success,
                    "Store has been updated successfully");
        } catch (DataAccessException dae) {
            result.addMessage(ApiMessage.MessageType.Error, "There is a problem updating data to the database");
        }

        return result;
    }

    /**
     * Remove a store by an identifier.
     * @param storeId represents identifier to remove.
     * @return object with the store removed, an attribute if any error exists, and a list with messages
     * to represent the result of the request.
     */
    public ApiResponse<StoreEntity> remove(String storeId) {
        ApiResponse<StoreEntity> result = new ApiResponse<>();
        try {

            StoreEntity storeEntity = storeDao.findStore(storeId);
            if( storeEntity == null){
                result.addMessage(ApiMessage.MessageType.Error, "The store does not exist");
                return result;
            } else {
                storeDao.delete(storeId);
            }

            result.setElement(storeEntity);
            result.addMessage(ApiMessage.MessageType.Success,
                    "Store has been removed successfully");
        } catch (DataAccessException dae) {
            result.addMessage(ApiMessage.MessageType.Error, "There is a problem deleting data to the database");
        }

        return result;
    }

    private boolean isValidStore(StoreDto storeDto, ApiResponse<StoreEntity> result){
        boolean allValuesAreCorrect = true;

        if(!storeDto.getAddress().isEmpty()){
            if(storeDto.getAddress().length() > 100){
                allValuesAreCorrect = false;
                result.addMessage(ApiMessage.MessageType.Warning, "The address value is not valid");
            }
        }

        if(!storeDto.getAddressNumber().isEmpty()){
            if(storeDto.getAddressNumber().length() > 8){
                allValuesAreCorrect = false;
                result.addMessage(ApiMessage.MessageType.Warning, "The addressNumber value is not valid");
            }
        }

        if(!storeDto.getNeightborhood().isEmpty()){
            if(storeDto.getNeightborhood().length() > 60){
                allValuesAreCorrect = false;
                result.addMessage(ApiMessage.MessageType.Warning, "The neightborhood value is not valid");
            }
        }

        if(!storeDto.getPostalCode().isEmpty()){
            if(storeDto.getPostalCode().length() > 9){
                allValuesAreCorrect = false;
                result.addMessage(ApiMessage.MessageType.Warning, "The postalCode value is not valid");
            }
        }

         if(!storeDto.getState().isEmpty()){
            if(storeDto.getState().length() > 30){
                allValuesAreCorrect = false;
                result.addMessage(ApiMessage.MessageType.Warning, "The State value is not valid");
            }
        }

       return allValuesAreCorrect;
    }

}
