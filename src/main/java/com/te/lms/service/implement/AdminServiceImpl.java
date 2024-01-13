package com.te.lms.service.implement;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.lms.dto.AdminDTO;
import com.te.lms.entity.Admin;
import com.te.lms.entity.AppUser;
import com.te.lms.entity.Employee;
import com.te.lms.entity.Roles;
import com.te.lms.repository.AdminRepository;
import com.te.lms.repository.AppUserRepository;
import com.te.lms.repository.EmployeeRepository;
import com.te.lms.repository.RoleRepository;
import com.te.lms.service.AdminService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

	private final EmployeeRepository employeeRepository;
	private final RoleRepository roleRepository;
	private final AppUserRepository appUserRepository;
	private final PasswordEncoder passwordEncoder;
	private final AdminRepository adminRepository;

	@Override
	public Optional<String> registerAdmin(AdminDTO adminDTO) {
		log.info("AdminServiceImpl:registerAdmin execution start, {}", adminDTO);
		Admin admin = new Admin();

		BeanUtils.copyProperties(adminDTO, admin);
		log.debug("AdminServiceImpl:registerAdmin, admin entity object created {}", admin);
		Optional<Roles> adminRole = roleRepository.findByRoleName("ROLE_ADMIN");
		if (adminRole.isPresent()) {
			log.debug("EmployeeServiceImpl:registerEmployee, role found in database");
			Roles roles = adminRole.get();
			AppUser appUser = AppUser.builder().username(admin.getAdminId())
					.password(passwordEncoder.encode(adminDTO.getPassword())).roles(new ArrayList<Roles>()).build();
			roles.getAppUsers().add(appUser);
			appUser.getRoles().add(roles);
			appUserRepository.save(appUser);
			log.info("AdminServiceImpl:registerAdmin, registraction done");
		}
		log.info("AdminServiceImpl:registerAdmin returning the data");
		return Optional.ofNullable(adminRepository.save(admin).getAdminId());
	}

}
