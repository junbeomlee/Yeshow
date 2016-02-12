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
@Table(name="good")
public class Good {
	
	@Id
	@Column(name="good_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long good_number;
	
	@ManyToOne
	@JoinColumn(name="tokenID", referencedColumnName="tokenID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="store_number", referencedColumnName="store_number")
	private Store store;
	
	public Good(){}

	
	public Good(long good_number, User user, Store store) {
		super();
		this.good_number = good_number;
		this.user = user;
		this.store = store;
	}


	public Good(User user, Store store) {
		// TODO Auto-generated constructor stub
		this.user=user;
		this.store=store;
	}


	public long getGood_number() {
		return good_number;
	}

	public void setGood_number(long good_number) {
		this.good_number = good_number;
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


	@Override
	public String toString() {
		return "Good [good_number=" + good_number + ", user=" + user + ", store=" + store + "]";
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
}
