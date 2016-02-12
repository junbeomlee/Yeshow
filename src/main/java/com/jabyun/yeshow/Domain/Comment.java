package com.jabyun.yeshow.Domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jabyun.yeshow.Util.Calender;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@Column(name="comment_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long comment_number;
	
	@ManyToOne
	@JoinColumn(name="tokenID", referencedColumnName="tokenID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="store_number", referencedColumnName="store_number")
	private Store store;
	
	@Column(name="contents")
	private String contents;
	
	@Embedded
	private CommentDate commentDate;
	
	public Comment(){}
	
	public Comment(User user, Store store, String contents, CommentDate commentDate) {
		super();
		this.user = user;
		this.store = store;
		this.contents = contents;
		this.commentDate = commentDate;
	}
	public Comment(long comment_number, User user, Store store, String contents, CommentDate commentDate) {
		super();
		this.comment_number = comment_number;
		this.user = user;
		this.store = store;
		this.contents = contents;
		this.commentDate = commentDate;
	}



	public Comment write(Store store,User user,String contents){
		
		Comment newComment = new Comment(user,store,contents,new CommentDate(new Date(Calender.getNowDate()),new Time(Calender.getNowDate())));
		return newComment;
	}

	public long getComment_number() {
		return comment_number;
	}

	public void setComment_number(long comment_number) {
		this.comment_number = comment_number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public CommentDate getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(CommentDate commentDate) {
		this.commentDate = commentDate;
	}
	
	
	
}
