package com.te.lms.controller;

import java.time.LocalDateTime;

import static com.te.lms.constant.Constants.FETCH_MENTOR_SUCESFULLY;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.te.lms.dto.MentorDTO;
import com.te.lms.entity.Mentor;
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
public class MentorController {

	private final JwtUtils jwtUtils;
	private final AuthenticationManager authenticationManager;
	private final EmployeeService employeeService;
	private final AdminService adminService;
	private final MentorService mentorService;

	@GetMapping(path = "/mentor/{mentorId}")
	public ResponseEntity<SuccessResponse> getMentor(@PathVariable String mentorId) {

		Mentor mentorDetails = mentorService.getMentorDetails(mentorId);

		return ResponseEntity.<SuccessResponse>ok().body(SuccessResponse.builder().data(mentorDetails)
				.message(FETCH_MENTOR_SUCESFULLY).timeStamp(LocalDateTime.now()).build());
	}

}
