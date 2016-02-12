package com.jabyun.yeshow.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jabyun.yeshow.Domain.History;
import com.jabyun.yeshow.Domain.Server;
import com.jabyun.yeshow.Domain.Store;

public interface HistoryRepository extends JpaRepository<History, Long>{

	@Query("select h from History h where h.user.tokenID=?1")
	List<History> findAllByTokenID(long tokenID);

	@Query("select h from History h where h.reservation_date >=?1 AND h.store.store_number=?2")
	List<History> findAllByMonth(Date sqlDate,Long store_number);

	@Query("select count(*) from History h where h.reservation_date >=?1 AND h.reservation_date <=?2 AND h.store.store_number=?3")
	int findAllByMonth(Date sqlDateStartMonth, Date sqlDateEndMonth, long parseLong);

	List<History> findByServer(Server server);

	List<History> findByStore(Store store);

}
