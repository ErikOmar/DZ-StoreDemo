package it.lab.store.demo.controller;

import it.lab.store.demo.model.store.StoreDto;
import it.lab.store.demo.model.store.StoreEntity;
import it.lab.store.demo.util.ApiResponse;
import it.lab.store.demo.util.ApiResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.lab.store.demo.services.store.StoreService;

import static it.lab.store.demo.util.APIControllerResponse.setApiResponse;

@RestController
@RequestMapping("/v1/store")
@CrossOrigin(origins = "*")
public class StoreController {

    @Autowired
    private StoreService storeService;

    /**
     * Get the list of all stores.
     * @return the list of all stores, a status attribute of if any error exists, and a list with messages
     * with the result of the request.
     */
    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseList<StoreEntity>> getStores() {

        ApiResponseList<StoreEntity> result = storeService.getStores();
        return setApiResponse(result);
    }

    /**
     * Add new store.
     * @param storeDto values of the store to add.
     * @return the added store, a status attribute of if any error exists, and a list with messages
     * with the result of the request.
     */
    @PostMapping(value = "")
    public ResponseEntity<ApiResponse<StoreEntity>> addStore(@RequestBody StoreDto storeDto) {
        ApiResponse<StoreEntity> result = storeService.add(storeDto);
        return setApiResponse(result);
    }

    /**
     * Modify an existing store.
     * @param storeDto values of the store to modify.
     * @param storeId the identifier of the store to modify.
     * @return the modified store, a status attribute of if any error exists, and a list with messages
     * with the result of the request.
     */
    @PutMapping(value = "{storeId}")
    public ResponseEntity<ApiResponse<StoreEntity>> updateStore(@RequestBody StoreDto storeDto, @PathVariable String storeId) {
        ApiResponse<StoreEntity> result = storeService.edit(storeDto, storeId);
        return setApiResponse(result);
    }

    /**
     * Remove a store.
     * @param storeId identifier the store to remove.
     * @return the store removed, a status attribute of if any error exists, and a list with messages
     * with the result of the request.
     */
    @DeleteMapping(value = "{storeId}")
    public ResponseEntity<ApiResponse<StoreEntity>> removeStore(@PathVariable String storeId) {
        ApiResponse<StoreEntity> result = storeService.remove(storeId);
        return setApiResponse(result);
    }

}
