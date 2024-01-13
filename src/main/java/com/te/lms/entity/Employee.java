package com.te.lms.entity;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
@Entity
@Builder
@Table(name = "employee_primary_info")
public class Employee {

	@Id
	@Column(name = "emp_id")
	private String empId;

	@NotNull(message = "NULL data passed for empName")
	@NotBlank(message = "BLANK data passes empName")
	@Column(name = "emp_name")
	private String empName;

	@NotNull
	@NotBlank
	@Email(message = "Email is not valid")
	@Column(name = "emp_email")
	private String email;

	@NotNull(message = "NULL data passed for dateOfBirth")
	@Column(name = "emp_dob")
	private LocalDate dateOfBirth;

	@NotNull(message = "NULL data passed for dateOfJoining")
	@Column(name = "emp_doj")
	private LocalDate dateOfJoining;

	@NotNull(message = "NULL data passed for designation")
	@NotBlank(message = "BLANK data passes designation")
	@Column(name = "designation")
	private String designation;

	@Column(name = "last_login")
	private LocalDate lastLogin;

	@Column(name = "status_reason")
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

	@OneToMany(cascade = CascadeType.ALL)
	private List<EmployeeAttendance> employeeAttendence;

	@ManyToOne(cascade = CascadeType.ALL)
	private Batch inBatch;

	@OneToOne(cascade = CascadeType.ALL)
	private SecondaryInfo secondaryInfo;

	@OneToMany(cascade = CascadeType.ALL)
	private List<EducationalDetails> educationDetails = new ArrayList();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private List<MockDetails> mockDetails = new ArrayList<MockDetails>();

	@OneToOne(cascade = CascadeType.ALL)
	private BankDetails bankDetails;

	@OneToMany(cascade = CascadeType.ALL)
	private List<TechnicalSkill> technicalSkills = new ArrayList<TechnicalSkill>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Experience> experiences = new ArrayList<Experience>();

	@OneToMany(cascade = CascadeType.ALL)
	private List<Contact> contacts = new ArrayList<Contact>();

}
