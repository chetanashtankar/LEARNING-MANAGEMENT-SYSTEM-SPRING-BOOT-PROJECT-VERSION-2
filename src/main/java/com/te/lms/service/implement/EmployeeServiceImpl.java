package com.te.lms.service.implement;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.lms.dto.AddressDTO;
import com.te.lms.dto.BankDetailsDTO;
import com.te.lms.dto.ContactDTO;
import com.te.lms.dto.EducationalDetailsDTO;
import com.te.lms.dto.EmployeeDTO;
import com.te.lms.dto.ExperienceDTO;
import com.te.lms.dto.SecondaryInfoDTO;
import com.te.lms.dto.TechnicalSkillDTO;
import com.te.lms.entity.Address;
import com.te.lms.entity.AppUser;
import com.te.lms.entity.BankDetails;
import com.te.lms.entity.Employee;
import com.te.lms.entity.Roles;
import com.te.lms.entity.SecondaryInfo;
import com.te.lms.entity.TechnicalSkill;
import com.te.lms.exception.EmployeeException;
import com.te.lms.repository.AppUserRepository;
import com.te.lms.repository.EmployeeRepository;
import com.te.lms.repository.RoleRepository;
import com.te.lms.service.EmployeeService;
import com.te.lms.utils.EmployeeUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final RoleRepository roleRepository;
	private final AppUserRepository appUserRepository;
	private final PasswordEncoder passwordEncoder;
	private final EmployeeUtils employeeUtils;

	@Override
	public Optional<String> registerEmployee(@Valid EmployeeDTO employeeDTO) {

		log.info("EmployeeServiceImpl:registerEmployee execution start, {}", employeeDTO);
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDTO, employee);
		log.debug("EmployeeServiceImpl:registerEmployee, employee entity object created {}", employee);
		Optional<Roles> employeeRole = roleRepository.findByRoleName("ROLE_EMPLOYEE");
		if (employeeRole.isPresent()) {
			log.debug("EmployeeServiceImpl:registerEmployee, role found in database");
			Roles roles = employeeRole.get();

			System.err.println(employeeDTO.getPassword());

			AppUser appUser = AppUser.builder().username(employee.getEmpId())
					.password(passwordEncoder.encode(employeeDTO.getPassword())).roles(new ArrayList<Roles>()).build();
			roles.getAppUsers().add(appUser);
			appUser.getRoles().add(roles);
			appUserRepository.save(appUser);
			log.info("EmployeeServiceImpl:registerEmployee, registraction done");
		}
		log.info("EmployeeServiceImpl:registerEmployee returning the data");
		return Optional.ofNullable(employeeRepository.save(employee).getEmpId());
	}

	@Override
	public Employee getEmpDetails(String empId) {

		Optional<Employee> findByEmpId = employeeRepository.findByEmpId(empId);
		if (findByEmpId.isPresent()) {
			return findByEmpId.get();
		}
		return null;
	}

	@Override
	public boolean updateEmployee(String empId, EmployeeDTO employeeDTO) {

		Employee employee = new Employee();
		SecondaryInfo secondaryInfo = new SecondaryInfo();
		BankDetails bankDetails = new BankDetails();

		Optional<Employee> findByEmpId = employeeRepository.findByEmpId(empId);
		if (findByEmpId.isPresent()) {

			BeanUtils.copyProperties(employeeDTO, employee);
			BeanUtils.copyProperties(employeeDTO, secondaryInfo);
			BeanUtils.copyProperties(employeeDTO, bankDetails);
			employee.setSecondaryInfo(secondaryInfo);
			employee.setBankDetails(bankDetails);
			employeeRepository.save(employee);

			return true;
		}
		return false;

	}

	@Override
	public EmployeeDTO getEmployee1(Employee employee) {

		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setBloodGroup(employee.getBloodGroup());
		employeeDTO.setDateOfBirth(employee.getDateOfBirth());
		employeeDTO.setDateOfJoining(employee.getDateOfJoining());
		employeeDTO.setDegree(employee.getDegree());
		employeeDTO.setDesignation(employee.getDesignation());
		employeeDTO.setEmail(employee.getEmail());
		employeeDTO.setEmpId(employee.getEmpId());
		employeeDTO.setEmpName(employee.getEmpName());
		employeeDTO.setGender(employee.getGender());
		employeeDTO.setLastLogin(employee.getLastLogin());
		employeeDTO.setNationality(employee.getNationality());
		employeeDTO.setStatus(employee.getStatus());
		employeeDTO.setStatusReason(employee.getStatusReason());

		List<AddressDTO> addressDTOlist = employee.getAddress().stream().map(t -> {
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setAddressId(t.getAddressId());
			addressDTO.setAddressType(t.getAddressType());
			addressDTO.setCity(t.getCity());
			addressDTO.setDoorNo(t.getDoorNo());
			addressDTO.setLandmark(t.getLandmark());
			addressDTO.setLocality(t.getLocality());
			addressDTO.setPincode(t.getPincode());
			addressDTO.setState(t.getState());
			addressDTO.setStreet(t.getStreet());

			return addressDTO;
		}).collect(Collectors.toList());
		employeeDTO.setAddress(addressDTOlist);

		List<TechnicalSkillDTO> technicalSkillDTOlist = employee.getTechnicalSkills().stream().map(t -> {
			TechnicalSkillDTO technicalSkillDTO = new TechnicalSkillDTO();
			technicalSkillDTO.setSkillId(t.getSkillId());
			technicalSkillDTO.setSkillRating(t.getSkillRating());
			technicalSkillDTO.setSkillType(t.getSkillType());
			technicalSkillDTO.setYearOfExperienceOnSkill(t.getYearOfExperienceOnSkill());

			return technicalSkillDTO;

		}).collect(Collectors.toList());
		employeeDTO.setTechnicalSkills(technicalSkillDTOlist);

		// Education details list

		List<EducationalDetailsDTO> educationalDetailsDTOlist = employee.getEducationDetails().stream().map(t -> {
			EducationalDetailsDTO educationalDetailsDTO = new EducationalDetailsDTO();
			educationalDetailsDTO.setEducationId(t.getEducationId());
			educationalDetailsDTO.setEducationType(t.getEducationType());
			educationalDetailsDTO.setInstituteName(t.getInstituteName());
			educationalDetailsDTO.setPercentage(t.getPercentage());
			educationalDetailsDTO.setSpecialization(t.getSpecialization());
			educationalDetailsDTO.setState(t.getState());
			educationalDetailsDTO.setUniversityName(t.getUniversityName());
			educationalDetailsDTO.setYearOfPassing(t.getYearOfPassing());

			return educationalDetailsDTO;
		}).collect(Collectors.toList());

		employeeDTO.setEducationalDetailsDTOs(educationalDetailsDTOlist);

		// experience list

		List<ExperienceDTO> experienceDTOlist = employee.getExperiences().stream().map(t -> {

			ExperienceDTO experienceDTO = new ExperienceDTO();
			experienceDTO.setCompanyName(t.getCompanyName());
			experienceDTO.setDataOfJoining(t.getDataOfJoining());
			experienceDTO.setDataOfRelieving(t.getDataOfRelieving());
			experienceDTO.setDesignation(t.getDesignation());
			experienceDTO.setExperienceId(t.getExperienceId());
			experienceDTO.setLocation(t.getLocation());
			experienceDTO.setYearsOfExperience(t.getYearsOfExperience());
			return experienceDTO;
		}).collect(Collectors.toList());
		employeeDTO.setExperienceDTOs(experienceDTOlist);

		// contact list

		List<ContactDTO> contactDTOlist = employee.getContacts().stream().map(t -> {

			ContactDTO contactDTO = new ContactDTO();
			contactDTO.setContactNumber(t.getContactNumber());
			contactDTO.setContactType(t.getContactType());

			return contactDTO;
		}).collect(Collectors.toList());
		employeeDTO.setContactDTOs(contactDTOlist);

		
		//bank details
		
		// BankDetailsDTO
	    BankDetailsDTO bankDetailsDTO = new BankDetailsDTO();
	    bankDetailsDTO.setAccountNo(employee.getBankDetails().getAccountNo());
	    bankDetailsDTO.setAccountType(employee.getBankDetails().getAccountType());
	    bankDetailsDTO.setBankName(employee.getBankDetails().getBankName());
	    bankDetailsDTO.setBranch(employee.getBankDetails().getBranch());
	    bankDetailsDTO.setIfsc(employee.getBankDetails().getIfsc());
		bankDetailsDTO.setState(employee.getBankDetails().getState());
	    employeeDTO.setBankDetailsDTO(bankDetailsDTO);

	    
	    // SecondaryInfoDTO
	    SecondaryInfoDTO secondaryInfoDTO = new SecondaryInfoDTO();
	    secondaryInfoDTO.setAadhaarNo(employee.getSecondaryInfo().getAadhaarNo());
	    secondaryInfoDTO.setFatherName(employee.getSecondaryInfo().getFatherName());
	    
	    secondaryInfoDTO.setMaritalStatus(employee.getSecondaryInfo().getMaritalStatus());
	    
	    secondaryInfoDTO.setMotherName(employee.getSecondaryInfo().getMotherName());
	    secondaryInfoDTO.setPanNo(employee.getSecondaryInfo().getPanNo());
	    secondaryInfoDTO.setPassportNo(employee.getSecondaryInfo().getPassportNo());
	    secondaryInfoDTO.setSpouseName(employee.getSecondaryInfo().getSpouseName());
	    
	    employeeDTO.setSecondaryInfoDTO(secondaryInfoDTO);
	    
	    
		return employeeDTO;

	}

	
	/*
	 * // @Override // public Optional<String> registerE mployee(EmployeeDTO
	 * employeeDTO) { // Employee employee = new Employee(); //
	 * employee.setEmpId(employeeDTO.getEmpId()); //
	 * employee.setEmpName(employeeDTO.getEmpName()); //
	 * employee.setEmail(employeeDTO.getEmail()); //
	 * employee.setDateOfBirth(employeeDTO.getDateOfBirth()); //
	 * employee.setDateOfJoining(employeeDTO.getDateOfJoining()); //
	 * employee.setDesignation(employeeDTO.getDesignation()); // //
	 * employeeRepository.save(employee); // // return
	 * Optional.of("Employee registered successfully"); // }
	 */
	
}
