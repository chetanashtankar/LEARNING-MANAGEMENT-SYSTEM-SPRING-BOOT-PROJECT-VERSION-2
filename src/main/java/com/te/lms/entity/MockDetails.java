package com.te.lms.entity;

import java.time.LocalDate;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.te.lms.enums.MockOn;
import com.te.lms.enums.MockRating;
import com.te.lms.enums.MockType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mock_details")
public class MockDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mock_id")
	private Integer mockId;

	@NotNull(message = "NULL data passed for mockDate")
	@Column(name = "mock_date")
	private LocalDate mockDate;

	@NotNull(message = "NULL data passed for practical")
	@Column(name = "practical")
	private Integer practical;

	@NotNull(message = "NULL data passed for theoritical")
	@Column(name = "theoritical")
	private Integer theoritical;

	@NotNull(message = "NULL data passed for mockFeedback")
	@NotBlank(message = "BLANK data passes mockFeedback")
	@Column(name = "mock_feedback")
	private String mockFeedback;

	@ManyToOne
	private Employee employee;

	@Enumerated(EnumType.STRING)
	private MockType mockType;

	@Enumerated(EnumType.STRING)
	private MockOn mockOn;

	@Enumerated(EnumType.STRING)
	private MockRating mockRating;

}
