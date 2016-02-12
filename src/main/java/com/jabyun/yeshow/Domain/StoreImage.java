package com.jabyun.yeshow.Domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="store_image")
public class StoreImage {
	
	@Id
	@Column(name="image_number")
	private long image_number;
	
	@ManyToOne
	@JoinColumn(name="store_number", referencedColumnName="store_number")
	private Store store;
	
	@Column(name="image_value")
	private int image_value;
	
	@Column(name="image_location")
	private String image_location;
	

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public long getImage_number() {
		return image_number;
	}

	public void setImage_number(long image_number) {
		this.image_number = image_number;
	}

	public int getImage_value() {
		return image_value;
	}

	public void setImage_value(int image_value) {
		this.image_value = image_value;
	}
	
	public String getImage_location() {
		return image_location;
	}

	public void setImage_location(String image_location) {
		this.image_location = image_location;
	}

	public StoreImage(){}

	public StoreImage(long image_number, Store store, int image_value, String image_location) {
		super();
		this.image_number = image_number;
		this.store = store;
		this.image_value = image_value;
		this.image_location = image_location;
	}
}

