package com.te.lms.service.implement;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.lms.dto.MentorDTO;
import com.te.lms.dto.MockDetailsDTO;
import com.te.lms.entity.AppUser;
import com.te.lms.entity.Batch;
import com.te.lms.entity.Employee;
import com.te.lms.entity.Mentor;
import com.te.lms.entity.Roles;
import com.te.lms.repository.AppUserRepository;
import com.te.lms.repository.EmployeeRepository;
import com.te.lms.repository.MentorRepository;
import com.te.lms.repository.RoleRepository;
import com.te.lms.service.MentorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MentorServiceImpl implements MentorService {

	private final EmployeeRepository employeeRepository;
	private final RoleRepository roleRepository;
	private final AppUserRepository appUserRepository;
	private final PasswordEncoder passwordEncoder;
	private final MentorRepository mentorRepository;

	@Override
	public Optional<String> registerMentor(MentorDTO mentorDTO) {
		log.info("Mentor ServiceImpl:registerMentor execution start, {}", mentorDTO);
		Mentor mentor = new Mentor();
		BeanUtils.copyProperties(mentorDTO, mentor);
		log.debug("Mentor ServiceImpl:registerEmployee, Mentor entity object created {}", mentorDTO);
		Optional<Roles> mentorRole = roleRepository.findByRoleName("ROLE_MENTOR");
		if (mentorRole.isPresent()) {
			log.debug("EmployeeServiceImpl:registerEmployee, role found in database");
			Roles roles = mentorRole.get();
			AppUser appUser = AppUser.builder().username(mentor.getMentorId())
					.password(passwordEncoder.encode(mentor.getPassword())).roles(new ArrayList<Roles>()).build();
			roles.getAppUsers().add(appUser);
			appUser.getRoles().add(roles);
			appUserRepository.save(appUser);
			log.info("EmployeeServiceImpl:registerEmployee, registraction done");
		}
		log.info("EmployeeServiceImpl:registerEmployee returning the data");
		return Optional.ofNullable(mentorRepository.save(mentor).getMentorId());
	}

	

	@Override
	public Mentor getMentorDetails(String mentorId) {

		Optional<Mentor> findById = mentorRepository.findById(mentorId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

}
