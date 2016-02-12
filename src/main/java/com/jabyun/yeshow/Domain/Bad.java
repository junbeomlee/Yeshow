package com.jabyun.yeshow.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bad")
public class Bad {
	
	@Id
	@Column(name="bad_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long bad_number;
	
	@ManyToOne
	@JoinColumn(name="tokenID", referencedColumnName="tokenID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="store_number", referencedColumnName="store_number")
	private Store store;
	
	public Bad(){}

	
	public Bad(long bad_number, User user, Store store) {
		super();
		this.bad_number = bad_number;
		this.user = user;
		this.store = store;
	}

	public Bad(User user, Store store) {
		// TODO Auto-generated constructor stub
		this.user=user;
		this.store=store;
	}


	public long getBad_number() {
		return bad_number;
	}

	public void setBad_number(long bad_number) {
		this.bad_number = bad_number;
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
	
}
