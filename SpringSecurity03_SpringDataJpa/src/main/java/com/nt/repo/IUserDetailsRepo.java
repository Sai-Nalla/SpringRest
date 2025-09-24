package com.nt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.UserDetail;



public interface IUserDetailsRepo extends JpaRepository<UserDetail, Integer> {

	Optional<UserDetail>  findByUname(String uname);

}
