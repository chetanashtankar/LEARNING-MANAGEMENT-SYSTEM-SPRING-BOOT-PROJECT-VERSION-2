package com.te.lms.controller;

import java.time.LocalDateTime;

import java.util.Optional;
import static com.te.lms.constant.Constants.FETCH_EMPLOYEE_SUCESFULLY;
import static com.te.lms.constant.Constants.UPDATE_EMPLOYEE_SUCESFULLY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.te.lms.dto.EmployeeDTO;
import com.te.lms.entity.Employee;
import com.te.lms.response.SuccessResponse;
import com.te.lms.service.AdminService;
import com.te.lms.service.EmployeeService;
import com.te.lms.service.MentorService;
import com.te.lms.utils.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/public")
public class EmployeeController {

	private final JwtUtils jwtUtils;
	private final AuthenticationManager authenticationManager;
	private final EmployeeService employeeService;
	private final AdminService adminService;
	private final MentorService mentorService;

	@GetMapping(path = "/getemployee/{empId}")
	public ResponseEntity<SuccessResponse> getEmployee(@PathVariable String empId) {

		Employee empDetails = employeeService.getEmpDetails(empId);
		return ResponseEntity.<SuccessResponse>ok().body(SuccessResponse.builder().data(empDetails)
				.message(FETCH_EMPLOYEE_SUCESFULLY).timeStamp(LocalDateTime.now()).build());
	}

	@PutMapping(path = "/updateEmployee")
	public ResponseEntity<SuccessResponse> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {

		boolean updateEmployee = employeeService.updateEmployee(employeeDTO.getEmpId(), employeeDTO);

		return ResponseEntity.<SuccessResponse>ok().body(SuccessResponse.builder().data(updateEmployee)
				.message(UPDATE_EMPLOYEE_SUCESFULLY).timeStamp(LocalDateTime.now()).build());
	}
}
