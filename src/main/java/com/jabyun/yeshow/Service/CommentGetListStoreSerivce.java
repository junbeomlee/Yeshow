package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Comment;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Repository.CommentRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Util.DuplicateException;

@Component("CommentGetListStoreSerivce")
public class CommentGetListStoreSerivce extends YeshowService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		// TODO Auto-generated method stub
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		System.out.println(dataObject.toJSONString());
		Store store=storeRepository.findOne(Long.parseLong((String)dataObject.get("store_number")));
		List<Comment> commentList=commentRepository.findByStore(store);
		for (Comment comment : commentList) {
			listFinalData.add(comment);
		}
		return listFinalData;
	}

}
