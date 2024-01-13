package com.te.lms.entity;

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

import com.te.lms.enums.State;

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
@Entity
@Table(name = "employee_education_details_info")
public class EducationalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private Integer educationId;

	@NotNull(message = "NULL data passed for educationType")
	@NotBlank(message = "BLANK data passes educationType")
	@Column(name = "education_type")
	private String educationType;

	@NotNull(message = "NULL data passed for yearOfPassing")
	@Column(name = "year_of_passing")
	private Integer yearOfPassing;

	@NotNull(message = "NULL data passed for percentage")
	@Column(name = "percentage")
	private Double percentage;

	@NotNull(message = "NULL data passed for universityName")
	@NotBlank(message = "BLANK data passes universityName")
	@Column(name = "university_name")
	private String universityName;

	@NotNull(message = "NULL data passed for instituteName")
	@NotBlank(message = "BLANK data passes instituteName")
	@Column(name = "institute_name")
	private String instituteName;

	@NotNull(message = "NULL data passed for specialization")
	@NotBlank(message = "BLANK data passes specialization")
	@Column(name = "specialization")
	private String specialization;

	@Enumerated(EnumType.STRING)
	private State state;

}
