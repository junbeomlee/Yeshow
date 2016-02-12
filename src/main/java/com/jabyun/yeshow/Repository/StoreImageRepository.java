package com.jabyun.yeshow.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jabyun.yeshow.Domain.StoreImage;

public interface StoreImageRepository extends JpaRepository<StoreImage, Long>{

	@Query("select e,p from Store p, StoreImage e where p.store_number=?1 and p.store_number=e.store.store_number")
	public List<Object> getStoreImage(long store_number);
	
}
