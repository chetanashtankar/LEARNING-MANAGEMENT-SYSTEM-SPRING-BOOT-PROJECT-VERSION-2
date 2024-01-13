package com.te.lms.entity;

import java.time.LocalDate;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.te.lms.enums.BatchStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "batch")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "batch_id")
	private Integer batchId;

	@NotNull(message = "NULL data passed for batchName")
	@NotBlank(message = "BLANK data passes batchName")
	@Column(name = "batch_name", unique = true)
	private String batchName;

	@NotNull(message = "NULL data passed for batchStartDate")
	@Column(name = "batch_start_date")
	private LocalDate batchStartDate;

	@Column(name = "batch_end_date")
	private LocalDate batchEndDate;

	@OneToMany(mappedBy = "inBatch", cascade = CascadeType.ALL)
	private List<Employee> employees;

	@Enumerated(EnumType.STRING)
	private BatchStatus batchStatus;

}
