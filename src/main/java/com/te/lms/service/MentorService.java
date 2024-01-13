package com.te.lms.service;

import java.util.Optional;

import com.te.lms.dto.EmployeeDTO;
import com.te.lms.dto.MentorDTO;
import com.te.lms.dto.MockDetailsDTO;
import com.te.lms.entity.Batch;
import com.te.lms.entity.Employee;
import com.te.lms.entity.Mentor;

public interface MentorService {

	Optional<String> registerMentor(MentorDTO mentorDTO);

	public Mentor getMentorDetails(String mentorId);

//	public abstract Batch getBatchData(String username);
//
//	public abstract Boolean addEmpMockData(String empId, MockDetailsDTO mockDetailsDTO);
//
//	// public abstract Boolean changeEmployeeStatus(EmpStatusModel empStatusModel);
//
//	public abstract Boolean createNewMock(String mentorId, MockDetailsDTO mockDetailsDTO);
}
