package com.jabyun.yeshow.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jabyun.yeshow.Domain.Promotion;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.StoreImage;

public interface StoreRepository extends JpaRepository<Store, Long>{
	
	@Query("select p,e from StoreImage e right join e.store p")
	public List<Object> findAllStoreAndImage();
}
