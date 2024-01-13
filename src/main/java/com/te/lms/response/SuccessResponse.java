package com.te.lms.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SuccessResponse {

	private Object data;
	private String message;
	private LocalDateTime timeStamp;
	private String token;
	
	
	
}
