package com.jabyun.yeshow.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jabyun.yeshow.Domain.Good;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;

public interface GoodRepository extends JpaRepository<Good,Long>{

	List<Good> findByStore(Store store);

	int countByStore(Store store);

	List<Good> findByStoreAndUser(Store store, User user);

}
