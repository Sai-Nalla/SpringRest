package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
	//has a Property
	private Company comp;
	

}
