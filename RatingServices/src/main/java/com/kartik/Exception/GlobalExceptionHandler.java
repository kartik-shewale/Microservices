package com.kartik.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandler {
	
	public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(Exception ex){
		
		Map<String, Object> map = new HashMap<String ,Object>();
		
		map.put("Message", ex.getMessage());
		map.put("Success", "False");
		map.put("Status", HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

}
