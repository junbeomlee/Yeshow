package com.jabyun.yeshow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.jabyun.yeshow.Domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
