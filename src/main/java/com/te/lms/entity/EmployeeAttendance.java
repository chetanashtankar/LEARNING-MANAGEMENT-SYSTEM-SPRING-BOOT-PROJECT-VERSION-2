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

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAttendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendence_id")
	private Integer attendenceId;

	@NotNull(message = "NULL data passed for attendenceDate")
	@Column(name = "attendence_date")
	private LocalDate attendenceDate;

	@NotNull(message = "NULL data passed for attendenceMorning")
	@Column(name = "attendence_morning")
	private Boolean attendenceMorning;

	@NotNull(message = "NULL data passed for attendenceNoon")
	@Column(name = "attendence_noon")
	private Boolean attendenceNoon;
}
