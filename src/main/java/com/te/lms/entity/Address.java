package com.te.lms.entity;

import jakarta.persistence.Column;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.te.lms.enums.AddressType;
import com.te.lms.enums.State;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_address_info")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Integer addressId;

	@Column(name = "door_no")
	private String doorNo;

	@Column(name = "street")
	private String street;

	@Column(name = "locality")
	private String locality;

//	@NotNull(message = "NULL data passed for city")
//	@NotBlank(message = "BLANK data passes city")
	@Column(name = "city")
	private String city;

//	@NotNull(message = "NULL data passed for pincode")
//	@Column(name = "pincode")
	private Integer pincode;

//	@NotNull(message = "NULL data passed for landmark")
//	@NotBlank(message = "BLANK data passes landmark")
	@Column(name = "landmark")
	private String landmark;

	@Enumerated(EnumType.STRING)
	private State state;

	@Enumerated(EnumType.STRING)
	private AddressType addressType;

	
}
