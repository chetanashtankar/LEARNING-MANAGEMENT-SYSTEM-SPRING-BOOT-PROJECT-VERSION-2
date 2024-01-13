package com.te.lms.dto;

import com.te.lms.enums.State;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankDetailsDTO {

	private Long accountNo;

	private String bankName;

	private String accountType;

	private String ifsc;

	private String branch;

	private String password;

	@Enumerated(EnumType.STRING)
	private State state;
}
