package it.lab.store.demo.controller;

import it.lab.store.demo.model.store.StoreDto;
import it.lab.store.demo.model.store.StoreEntity;
import it.lab.store.demo.util.ApiResponse;
import it.lab.store.demo.util.ApiResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.lab.store.demo.services.StoreService;

import static it.lab.store.demo.util.APIControllerResponse.setApiResponse;

@RestController
@RequestMapping("/v1/store")
@CrossOrigin(origins = "*")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseList<StoreEntity>> getStores() {

        ApiResponseList<StoreEntity> result = storeService.getStores();
        return setApiResponse(result);
    }

    @PostMapping(value = "")
    public ResponseEntity<ApiResponse<StoreEntity>> addStore(@RequestBody StoreDto storeDto) {
        ApiResponse<StoreEntity> result = storeService.add(storeDto);
        return setApiResponse(result);
    }

    @PutMapping(value = "{storeId}")
    public ResponseEntity<ApiResponse<StoreEntity>> updateStore(@RequestBody StoreDto storeDto, @PathVariable String storeId) {
        ApiResponse<StoreEntity> result = storeService.edit(storeDto, storeId);
        return setApiResponse(result);
    }

    @DeleteMapping(value = "{storeId}")
    public ResponseEntity<ApiResponse<StoreEntity>> updateStore(@PathVariable String storeId) {
        ApiResponse<StoreEntity> result = storeService.remove(storeId);
        return setApiResponse(result);
    }

}
