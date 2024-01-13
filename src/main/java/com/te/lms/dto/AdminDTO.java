package com.te.lms.dto;

import com.te.lms.enums.Gender;
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
public class AdminDTO {

	private String adminId;

	private String name;

	private String email;

	private String password;

	@Enumerated(EnumType.STRING)
	private Gender gender;
}
