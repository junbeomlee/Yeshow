package com.jabyun.yeshow.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Comment;
import com.jabyun.yeshow.Domain.Favorite;
import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;
import com.jabyun.yeshow.Repository.CommentRepository;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Repository.UserRepository;
import com.jabyun.yeshow.Util.DuplicateException;

@Component("CommentInsertService")
public class CommentInsertService extends YeshowService{

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StoreRepository storeRepository;
	
	@Transactional
	@Override
	public ArrayList<Object> execute(JSONObject dataObject) throws SQLException, DuplicateException {
		// TODO Auto-generated method stub
		
		ArrayList<Object> listFinalData = new ArrayList<Object>();
		
		Store store = storeRepository.findOne(Long.parseLong((String)dataObject.get("store_number")));
		User user= userRepository.findOne(Long.parseLong((String)dataObject.get("tokenID")));
		String contents = (String)dataObject.get("contents");
		//Favorite favorite=(Favorite)commentRepository.findByTokenIDAndStoreNumber(user.getTokenID(),store.getStore_number());
		
			// delete안된다.
		Comment comment= new Comment();
		comment=comment.write(store, user, contents);
		commentRepository.save(comment);
		
		listFinalData.add(comment);
		
		
		return listFinalData;
	}

}
