package com.jabyun.yeshow.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jabyun.yeshow.Domain.Comment;
import com.jabyun.yeshow.Domain.Store;

public interface CommentRepository extends JpaRepository<Comment,Long>{

	List<Comment> findByStore(Store store);

}
