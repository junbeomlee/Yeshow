package com.jabyun.yeshow.Domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommentDate {
	@Column(name="comment_date")
	private Date date;
	
	@Column(name="comment_time")
	private Time time;
	
	public CommentDate(){}
	public CommentDate(Date date, Time time) {
		super();
		this.date = date;
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	
	
	
}
