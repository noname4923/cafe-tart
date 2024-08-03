package com.cafe.tart.common.exeption;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {

	/**
	 *  클라이언트에서 요청을 잘못 한 경우 
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException ex) {
		Map<String, String> response = new HashMap<>();
		Throwable cause = ex.getCause();

		if (cause instanceof InvalidFormatException) {
			InvalidFormatException ife = (InvalidFormatException) cause;
			response.put("error", "잘못된 format");
			response.put("message", ife.getOriginalMessage());
		} 
		else if(cause instanceof NumberFormatException) {
			NumberFormatException nfe = (NumberFormatException) cause;
			response.put("error", "잘못된 Number format");
			response.put("message", nfe.getMessage());
		}
		else {
			response.put("error", "잘못된 JSON format");
			response.put("message", ex.getMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	/* 필수 파라미터를 입력하지 않은 경우 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        String errorMessage = "필수 파라미터를 입력해 주세요 : '" + ex.getParameterName() + "' 필요합니다.";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
	
	/** 
	 * 서버에 문제가 있을 경우 
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
		Map<String, String> response = new HashMap<>();
		response.put("error", "Internal server error");
		response.put("message", ex.getMessage());
		response.put("MSG", "서버에서 문제가 발생했습니다.");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}