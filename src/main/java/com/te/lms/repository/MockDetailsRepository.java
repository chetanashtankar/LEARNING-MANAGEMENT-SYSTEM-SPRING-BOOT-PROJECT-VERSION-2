package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.MockDetails;

@Repository
public interface MockDetailsRepository extends JpaRepository<MockDetails, Integer> {

}
