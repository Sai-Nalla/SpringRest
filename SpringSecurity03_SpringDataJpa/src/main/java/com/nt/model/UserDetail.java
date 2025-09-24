package com.nt.model;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="User_security")
@Data
@Entity
public class UserDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=5)
	private Integer unid;
	@Column(length = 20,unique = true,nullable = false)
	private String uname;
	@Column(length=150,unique = true,nullable = false)
	private String pwd;
	@Column(length=15,nullable = false)
	private String email;
	private Boolean status=true;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="Role_security",
					joinColumns = @JoinColumn(name = "USER_ID",referencedColumnName ="unid"))
	@Column(name="role")
	private Set<String> roles;

}
