package com.te.lms.service;

import java.util.Optional;

import org.springframework.boot.env.ConfigTreePropertySource.Option;
import org.springframework.stereotype.Service;

import com.te.lms.dto.EmployeeDTO;
import com.te.lms.entity.Employee;

public interface EmployeeService {

	Optional<String> registerEmployee(EmployeeDTO employeeDTO);

//	Optional<String> registerEmployee(Employee employee);
	
	public Employee getEmpDetails(String empId);
	
	//public Employee getEmployee(String empId);
	
	public EmployeeDTO getEmployee1(Employee employee);

	public boolean updateEmployee(String empId, EmployeeDTO employeeDTO);

}
