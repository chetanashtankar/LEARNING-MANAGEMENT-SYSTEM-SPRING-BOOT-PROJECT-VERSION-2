package com.te.lms.entity;

import com.te.lms.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "admin")
public class Admin {

	@Id
	@Column(name = "admin_id")
	private String adminId;

	@NotNull
	@NotBlank
	@Column(name = "admin_name")
	private String name;

	@NotNull
	@NotBlank
	@Email(message = "Email is not valid")
	@Column(name = "admin_email", unique = true)
	private String email;

	@Enumerated(EnumType.STRING)
	private Gender gender;
}
