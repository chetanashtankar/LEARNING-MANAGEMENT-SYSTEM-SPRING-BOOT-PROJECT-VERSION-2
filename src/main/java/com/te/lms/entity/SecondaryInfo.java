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
import com.te.lms.enums.MaritalStatus;

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
@Table(name = "employee_secondary_info")
public class SecondaryInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pan_no")
	private String panNo;

	@NotNull(message = "NULL data passed for aadhaarNo")
	@NotBlank(message = "BLANK data passes aadhaarNo")
	@Column(name = "aadhaar_no", unique = true)
	private String aadhaarNo;

	@NotNull(message = "NULL data passed for fatherName")
	@NotBlank(message = "BLANK data passes fatherName")
	@Column(name = "father_name")
	private String fatherName;

	@NotNull(message = "NULL data passed for motherName")
	@NotBlank(message = "BLANK data passes motherName")
	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "spouse_name")
	private String spouseName;

	@Column(name = "passport_no")
	private String passportNo;

	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;
}
