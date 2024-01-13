package com.te.lms.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.te.lms.enums.MockOn;
import com.te.lms.enums.MockRating;
import com.te.lms.enums.MockType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MockDetailsDTO {

	private Integer mockId;

	private LocalDate mockDate;

	private Integer practical;

	private Integer theoritical;

	private String mockFeedback;

	@Enumerated(EnumType.STRING)
	private MockType mockType;

	@Enumerated(EnumType.STRING)
	private MockOn mockOn;

	@Enumerated(EnumType.STRING)
	private MockRating mockRating;
}
