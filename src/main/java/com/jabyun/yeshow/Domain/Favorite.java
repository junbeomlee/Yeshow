package com.jabyun.yeshow.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="favorite")
public class Favorite {
	
	@Id
	@Column(name="favorite_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long favorite_number;
	
	@ManyToOne
	@JoinColumn(name="tokenID", referencedColumnName="tokenID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="store_number", referencedColumnName="store_number")
	private Store store;
	
	public Favorite(){}
	public Favorite(long favorite_number, User user, Store store) {
		super();
		this.favorite_number = favorite_number;
		this.user = user;
		this.store = store;
	}
	
	public Favorite makeFavorite(User user,Store store){
		
		this.user=user;
		this.store=store;
		
		return this;
	}

	public void setFavorite_number(long favorite_number) {
		this.favorite_number = favorite_number;
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
	
	public long getFavorite_number() {
		return favorite_number;
	}

	
}
