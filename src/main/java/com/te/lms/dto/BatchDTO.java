package com.te.lms.dto;

import java.time.LocalDate;

import com.te.lms.enums.BatchStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchDTO {

	private Integer batchId;

	private String batchName;

	private LocalDate batchStartDate;

	private LocalDate batchEndDate;

	private String password;

	@Enumerated(EnumType.STRING)
	private BatchStatus batchStatus;
}
