package com.te.lms.controller;

import java.time.LocalDateTime;
import static com.te.lms.constant.Constants.LOGIN_SUCESFULLY;
import static com.te.lms.constant.Constants.REGISTER_EMPLOYEE_SUCESFULLY;
import static com.te.lms.constant.Constants.REGISTER_MENTOR_SUCESFULLY;
import static com.te.lms.constant.Constants.REGISTER_ADMIN_SUCESFULLY;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.te.lms.dto.AdminDTO;
import com.te.lms.dto.EmployeeDTO;
import com.te.lms.dto.LoginDTO;
import com.te.lms.dto.MentorDTO;
import com.te.lms.response.SuccessResponse;
import com.te.lms.service.AdminService;
import com.te.lms.service.EmployeeService;
import com.te.lms.service.MentorService;
import com.te.lms.utils.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/public")
public class ApplicationController {

	private final JwtUtils jwtUtils;
	private final AuthenticationManager authenticationManager;
	private final EmployeeService employeeService;
	private final AdminService adminService;
	private final MentorService mentorService;

	@PostMapping(path = "/employee/register")
	public ResponseEntity<SuccessResponse> registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
		log.info("TrainerController:registerTrainer execution start, {}", employeeDTO);
		Optional<String> registerEmployee = employeeService.registerEmployee(employeeDTO);
		return ResponseEntity.<SuccessResponse>ok().body(SuccessResponse.builder().data(registerEmployee.get())
				.message(REGISTER_EMPLOYEE_SUCESFULLY).timeStamp(LocalDateTime.now()).build());
	}

	@PostMapping(path = "/mentor/register")
	public ResponseEntity<SuccessResponse> registerMentor(@RequestBody MentorDTO mentorDTO) {
		log.info("MentorController:registerMentor execution start, {}", mentorDTO);

		Optional<String> registerMentor = mentorService.registerMentor(mentorDTO);
		return ResponseEntity.<SuccessResponse>ok().body(SuccessResponse.builder().data(registerMentor)
				.message(REGISTER_MENTOR_SUCESFULLY).timeStamp(LocalDateTime.now()).build());
	}

	@PostMapping(path = "/admin/register")
	public ResponseEntity<SuccessResponse> registerAdmin(@RequestBody AdminDTO adminDTO) {

		log.info("MentorController:registerMentor execution start, {}", adminDTO);
		Optional<String> registerAdmin = adminService.registerAdmin(adminDTO);
		return ResponseEntity.<SuccessResponse>ok().body(SuccessResponse.builder().data(registerAdmin)
				.message(REGISTER_ADMIN_SUCESFULLY).timeStamp(LocalDateTime.now()).build());
	}

	@PostMapping(path = "/login")
	public ResponseEntity<SuccessResponse> login(@RequestBody LoginDTO loginDto) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		String token = jwtUtils.generateToken(loginDto.getUsername());
		return ResponseEntity.<SuccessResponse>ok().body(SuccessResponse.builder().token(token)
				.message(LOGIN_SUCESFULLY).timeStamp(LocalDateTime.now()).build());
	}

}
