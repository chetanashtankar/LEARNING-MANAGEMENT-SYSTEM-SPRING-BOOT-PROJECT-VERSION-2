package com.te.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {

	Optional<AppUser> findByUsername(String username);
}
