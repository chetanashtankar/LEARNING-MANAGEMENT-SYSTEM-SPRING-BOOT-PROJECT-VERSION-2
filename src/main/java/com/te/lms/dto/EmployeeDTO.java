package com.te.lms.dto;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.te.lms.dto.AddressDTO.AddressDTOBuilder;
import com.te.lms.entity.Address;
import com.te.lms.entity.SecondaryInfo;
import com.te.lms.entity.TechnicalSkill;
import com.te.lms.enums.BloodGroup;
import com.te.lms.enums.Degree;
import com.te.lms.enums.EmployeeStatus;
import com.te.lms.enums.Gender;
import com.te.lms.enums.Nationality;

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
public class EmployeeDTO {

	private String empId;

	private String empName;

	private String email;

	private LocalDate dateOfBirth;

	private LocalDate dateOfJoining;

	private String designation;

	private LocalDate lastLogin;

	private String statusReason;

	private String Password;

	@Enumerated(EnumType.STRING)
	private Nationality nationality;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;

	@Enumerated(EnumType.STRING)
	private Degree degree;

	@Enumerated(EnumType.STRING)
	private EmployeeStatus status;

	private List<AddressDTO> address;

	private List<TechnicalSkillDTO> technicalSkills = new ArrayList<TechnicalSkillDTO>();

	private SecondaryInfoDTO secondaryInfoDTO;

	private List<EducationalDetailsDTO> educationalDetailsDTOs = new ArrayList<EducationalDetailsDTO>();

	private BankDetailsDTO bankDetailsDTO;

	private List<ExperienceDTO> experienceDTOs = new ArrayList<ExperienceDTO>();

	private List<ContactDTO> contactDTOs = new ArrayList<ContactDTO>();

}
