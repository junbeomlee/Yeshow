package com.jabyun.yeshow.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jabyun.yeshow.Domain.History;
import com.jabyun.yeshow.Domain.Reservation;
import com.jabyun.yeshow.Domain.Server;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findByUser(User user);

	List<Reservation> findByStore(Store store);

	void deleteByUser(User findOne);

	@Query("select h from Reservation h where h.store=?1 AND h.reservation_date=?2")
	List<Reservation> findByStoreToday(Store store, Date dateToday);

	@Query("select h from Reservation h where h.store=?1 AND h.server=?2 AND h.reservation_date=?3")
	List<Reservation> findByStoreAndUserInTime(Store store, Server server, java.sql.Date sqlDate);
}
