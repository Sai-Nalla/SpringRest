package com.nt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private Integer cno;
	private String cname;
	private Float billAmt;
	private String[] favColors;
	private List<String> nickNames;
	private Set<Long> phoneNumbers;
	private Map<String,Object> idDetails;
	
	@JsonFormat(pattern="MM-dd-yyy HH:mm:ss")
	private LocalDateTime purchasedDate;
	@JsonFormat(pattern = "MM-dd-yyyy")
	private LocalDate dob;
	//has a Property
	private Address addrs;
	

}
