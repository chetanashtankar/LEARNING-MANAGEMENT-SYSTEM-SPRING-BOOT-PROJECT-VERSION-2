package com.te.lms.utils;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.te.lms.dto.AddressDTO;
import com.te.lms.dto.EmployeeDTO;
import com.te.lms.dto.TechnicalSkillDTO;
import com.te.lms.entity.Employee;
import com.te.lms.repository.EmployeeRepository;
import com.te.lms.repository.RequestListRepository;

@Component
public class EmployeeUtils {

	private EmployeeRepository employeeRepository;

//	 EmployeeDTO employeeDTO = new EmployeeDTO();
//	 BeanUtils.copyProperties(employee, employeeDTO);
//	 employeeDTO.setAddresses(employee.getAddresses().stream() .map(a ->
//	 AddressDTO.builder().city(a.getCity()).state(a.getState()).build())
//	 .collect(Collectors.toList()));
//	 
//	 employeeDTO.setSkills(employee.getSkills().stream() .map(s ->
//	 SkillDTO.builder().skillName(s.getSkillName()).build()).collect(Collectors.
//	 toList())); 
//	 return employeeDTO;
//	 
//
//	
//	 public EmployeeDTO entityToDTO(Employee employee) {
//	 
//	 EmployeeDTO employeeDTO = new EmployeeDTO();
//	 BeanUtils.copyProperties(employee, employeeDTO);
//	 employeeDTO.setAddress(employee.getAddress().stream() .map(a ->
//	 AddressDTO.builder().city(a.getCity()).doorNo(a.getDoorNo()).landmark(a.
//	 getLandmark())
//	 .locality(a.getLocality()).pincode(a.getPincode()).street(a.getStreet())
//	 .addressType(a.getAddressType()).state(a.getState()).build())
//	 .collect(Collectors.toList()));
//	 
//	 // employeeDTO.setSecondaryInfo(employee.getSecondaryInfo());
//	 
//	 employeeDTO.setTechnicalSkills(employee .getTechnicalSkills().stream().map(a
//	 -> TechnicalSkillDTO.builder().skillId(a.getSkillId())
//	 .skillType(a.getSkillType()).yearOfExperienceOnSkill(a.
//	 getYearOfExperienceOnSkill()).build()) .collect(Collectors.toList()));
//	 
//	 return employeeDTO;
//	 

	public Employee dtoToEntity(EmployeeDTO employeeDTO) {

		return Employee.builder().bloodGroup(employeeDTO.getBloodGroup()).dateOfBirth(employeeDTO.getDateOfBirth())
				.dateOfJoining(employeeDTO.getDateOfJoining()).degree(employeeDTO.getDegree())
				.designation(employeeDTO.getDesignation()).email(employeeDTO.getEmail())
				.empName(employeeDTO.getEmpName()).gender(employeeDTO.getGender())
				.nationality(employeeDTO.getNationality()).status(employeeDTO.getStatus()).build();

	}

}
