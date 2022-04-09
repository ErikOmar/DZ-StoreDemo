package it.lab.store.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class APIControllerResponse {

    public static <T> ResponseEntity<ApiResponseList<T>> setApiResponse(
            final ApiResponseList<T> resultado) {
        if(resultado.getHasError()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultado);
        }
        if(resultado.getList() != null && resultado.getList().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

    public static <T> ResponseEntity<ApiResponse<T>> setApiResponse(
            final ApiResponse<T> resultado) {
        if(resultado.getHasError()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultado);
        }
        if(resultado.getElement() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

}
