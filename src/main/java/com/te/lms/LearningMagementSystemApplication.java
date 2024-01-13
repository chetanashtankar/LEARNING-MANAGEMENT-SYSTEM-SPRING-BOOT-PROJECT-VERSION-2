
package com.te.lms;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.te.lms.entity.Admin;
import com.te.lms.entity.AppUser;
import com.te.lms.entity.Roles;
import com.te.lms.repository.AdminRepository;
import com.te.lms.repository.AppUserRepository;
import com.te.lms.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class LearningMagementSystemApplication {

	private final AdminRepository adminRepository;
	private final RoleRepository roleRepository;
	private final AppUserRepository appUserRepository;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(LearningMagementSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {

		return args -> {

			Roles emplRoles = Roles.builder().roleName("ROLE_EMPLOYEE").build();
			Roles mentRoles = Roles.builder().roleName("ROLE_MENTOR").build();
			Roles adminRoles = Roles.builder().roleName("ROLE_ADMIN").appUsers(new ArrayList<AppUser>()).build();

			emplRoles = roleRepository.save(emplRoles);
			mentRoles = roleRepository.save(mentRoles);
			adminRoles = roleRepository.save(adminRoles);

			Admin admin = Admin.builder().adminId("ADMIN01").email("ADMIN@123").name("ADMIN123").build();

			AppUser adminCredentials = AppUser.builder().username(admin.getAdminId())
					.password(passwordEncoder.encode("qwerty")).roles(new ArrayList<Roles>()).build();

			adminRepository.save(admin);

			adminCredentials.getRoles().add(adminRoles);

			adminRoles.getAppUsers().add(adminCredentials);

			roleRepository.save(adminRoles);

			appUserRepository.save(adminCredentials);

		};

	}

}
