package com.jabyun.yeshow.Domain;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StoreDetail {
	
	@Column(name="location")
	private String location;
	
	@Column(name="store_phone")
	private String store_phone;
	
	@Column(name="store_info")
	private String store_info;
	
	@Column(name="open_time")
	private Time open_time;
	
	@Column(name="close_time")
	private Time close_time;
	
	public StoreDetail(){}

	public StoreDetail(String location, String store_phone, String store_info, Time open_time,
			Time close_time) {
		super();
		this.location = location;
		this.store_phone = store_phone;
		this.store_info = store_info;
		this.open_time = open_time;
		this.close_time = close_time;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStore_phone() {
		return store_phone;
	}

	public void setStore_phone(String store_phone) {
		this.store_phone = store_phone;
	}

	public String getStore_info() {
		return store_info;
	}

	public void setStore_info(String store_info) {
		this.store_info = store_info;
	}

	public Time getOpen_time() {
		return open_time;
	}

	public void setOpen_time(Time open_time) {
		this.open_time = open_time;
	}

	public Time getClose_time() {
		return close_time;
	}

	public void setClose_time(Time close_time) {
		this.close_time = close_time;
	}

	@Override
	public String toString() {
		return "StoreDetail [location=" + location + ", store_phone=" + store_phone + ", store_info=" + store_info
				+ ", open_time=" + open_time + ", close_time=" + close_time + "]";
	}
}
