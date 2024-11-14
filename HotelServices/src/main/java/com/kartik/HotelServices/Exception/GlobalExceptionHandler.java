package com.kartik.HotelServices.Exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {

        Map<String, Object> map = new HashMap<>();

        map.put("message", ex.getMessage());
        map.put("success", "False");
        map.put("status", HttpStatus.NOT_FOUND.value());
        
        // Returning a ResponseEntity with the error details and a 404 status
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
