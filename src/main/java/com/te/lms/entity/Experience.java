package com.te.lms.entity;

import java.time.LocalDate;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.te.lms.enums.YearsOfExperience;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_experience_info")
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private Integer experienceId;

	@NotNull(message = "NULL data passed for companyName")
	@NotBlank(message = "BLANK data passes companyName")
	@Column(name = "company_name")
	private String companyName;

	@NotNull(message = "NULL data passed for dataOfJoining")
	@Column(name = "data_of_joining")
	private LocalDate dataOfJoining;

	@NotNull(message = "NULL data passed for dataOfRelieving")
	@Column(name = "data_of_relieving")
	private LocalDate dataOfRelieving;

	@NotNull(message = "NULL data passed for designation")
	@NotBlank(message = "BLANK data passes designation")
	@Column(name = "designation")
	private String designation;

	@NotNull(message = "NULL data passed for location")
	@NotBlank(message = "BLANK data passes location")
	@Column(name = "location")
	private String location;

	@Enumerated(EnumType.ORDINAL)
	private YearsOfExperience yearsOfExperience;
}
