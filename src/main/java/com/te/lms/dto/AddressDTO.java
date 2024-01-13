package com.te.lms.dto;

import com.te.lms.enums.AddressType;
import com.te.lms.enums.State;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {

	private Integer addressId;

	private String doorNo;

	private String street;

	private String locality;

	private String city;

	private Integer pincode;

	private String landmark;

	private String password;

	@Enumerated(EnumType.STRING)
	private State state;

	@Enumerated(EnumType.STRING)
	private AddressType addressType;
}
