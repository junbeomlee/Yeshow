package com.jabyun.yeshow.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jabyun.yeshow.Domain.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

	@Query("select p.store from Favorite p where p.user.tokenID=?1")
	public List<Object> findAllByTokenId(long tokenID);
	
	@Query("select p from Favorite p where p.user.tokenID=?1 and p.store.store_number=?2")
	public Object findByTokenIDAndStoreNumber(long tokenID, long Store_number);
	
}
