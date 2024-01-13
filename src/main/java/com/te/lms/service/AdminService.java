package com.te.lms.service;

import java.util.List;
import java.util.Optional;

import com.te.lms.dto.AdminDTO;
import com.te.lms.dto.BatchDTO;
import com.te.lms.dto.EmployeeDTO;
import com.te.lms.entity.Batch;

public interface AdminService {

	//Optional<String> registerEmployee(EmployeeDTO employeeDTO);
	
	Optional<String>registerAdmin(AdminDTO adminDTO);
	
//	//public abstract List<BatchResponseModel> getBatcheList();
//
//	public abstract BatchModel saveBatch(BatchModel batchModel);
//
//	public abstract BatchModel updateBatch(BatchModel batchModel);
//
//	public abstract Boolean deleteBatch(String batchName);
//
//	public abstract Boolean addEmployeeToBatchModel(AddEmployeeToBatchModel addEmployeeToBatchModel);
//
//	public abstract List<Request> getRequestList();
//
//	public abstract Boolean rejectRequest(RejectRegisterRequestModel rejectRequest);
//
//	public abstract MentorModel saveMentor(MentorModel mentorModel);
//
//	public abstract List<MentorModel> getMentorList();
//
//	public abstract Boolean deleteMentor(String mentorName);
	
	
	
	

}
