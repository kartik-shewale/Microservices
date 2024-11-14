package com.kartik.app.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.kartik.app.PayLoad.ApiResponse;

@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> HandleResourceNotFounException(ResourceNotFoundException ex) {

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(ex.getMessage());
		apiResponse.setSuccess(false);
		apiResponse.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
}