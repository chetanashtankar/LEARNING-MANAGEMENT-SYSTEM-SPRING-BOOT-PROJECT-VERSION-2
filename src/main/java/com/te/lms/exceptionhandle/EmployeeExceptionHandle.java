package com.te.lms.exceptionhandle;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.lms.exception.BatchException;
import com.te.lms.exception.EmployeeException;
import com.te.lms.exception.MentorException;
import com.te.lms.exception.PasswordNotResetException;
import com.te.lms.response.ErrorResponse;

@RestControllerAdvice
public class EmployeeExceptionHandle {

	/* employee exception handle..! */
	@ExceptionHandler(value = EmployeeException.class)
	public ResponseEntity<ErrorResponse> employeeHandle(RuntimeException runtimeException) {

		return ResponseEntity.<ErrorResponse>ok().body(
				ErrorResponse.builder().message("employee exception handle..!").timeStamp(LocalDateTime.now()).build());

	}

	/* batch exception handle..! */
	@ExceptionHandler(value = BatchException.class)
	public ResponseEntity<ErrorResponse> BatchExceptionHandle(RuntimeException runtimeException) {

		return ResponseEntity.<ErrorResponse>ok(
				ErrorResponse.builder().message("Batch exception handle..!").timeStamp(LocalDateTime.now()).build());
	}

	/* mentor exception handle..! */
	@ExceptionHandler(value = MentorException.class)
	public ResponseEntity<ErrorResponse> MentorExceptionHandle(RuntimeException runtimeException) {

		return ResponseEntity.<ErrorResponse>ok(
				ErrorResponse.builder().message("MentorException handle..!").timeStamp(LocalDateTime.now()).build());
	}

	/* Password exception handle..! */
	@ExceptionHandler(value = PasswordNotResetException.class)
	public ResponseEntity<ErrorResponse> PasswordNotResetExceptionHandle(RuntimeException runtimeException) {

		return ResponseEntity.<ErrorResponse>ok(ErrorResponse.builder().message("PasswordNotResetException handle..!")
				.timeStamp(LocalDateTime.now()).build());
	}

}
