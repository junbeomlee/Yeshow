package com.jabyun.yeshow.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jabyun.yeshow.Domain.Bad;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;

public interface BadRepository extends JpaRepository<Bad,Long>{

	List<Bad> findByStore(Store store);

	List<Bad> findByStoreAndUser(Store store, User user);

}
