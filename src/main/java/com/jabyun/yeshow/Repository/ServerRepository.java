package com.jabyun.yeshow.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jabyun.yeshow.Domain.Server;
import com.jabyun.yeshow.Domain.Store;

public interface ServerRepository extends JpaRepository<Server, Long>{

	List<Server> findByStore(Store store);

	//@Query("insert into Server p (p.server_number,p.store.store_number,p.server_name,p.server_offtime) VALUES (?1,?2,?3,?4)")
	//public void saveOne(long server_number,long store_number,String server_name,String server_offtime);
	
}
