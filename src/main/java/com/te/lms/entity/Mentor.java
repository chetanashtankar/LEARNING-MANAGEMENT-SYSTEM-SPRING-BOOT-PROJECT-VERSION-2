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
@Entity
@Table(name = "mentor")
public class Mentor {

	@Id
	@Column(name = "mentor_id")
	private String mentorId;

	@NotNull(message = "NULL data passed for mentorName")
	@NotBlank(message = "BLANK data passes mentorName")
	@Column(name = "mentor_name")
	private String mentorName;

	@NotNull(message = "NULL data passed for email")
	@NotBlank(message = "BLANK data passes for email")
	@Email(message = "Email is not valid")
	@Column(name = "mentor_email")
	private String email;
	
	private String password;
}
