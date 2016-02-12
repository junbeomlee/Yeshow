package com.jabyun.yeshow.Domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class Store {
	
	@Id
	@Column(name="store_number")
	private long store_number;
	
	@Column(name="store_name")
	private String store_name;
	
	@Column(name="kind")
	private String kind;
	
	@Column(name="district")
	private String district;
	
	@Column(name="store_password")
	private String store_password;
	
	@Embedded
	private Promotion promotion;
	
	@Embedded
	private StoreDetail storeDetail;	
	
	@Column(name="role")
	private String role;

	public Store(){}
	
	

	public Store(long store_number, String store_name, String kind, String district, String store_password,
			Promotion promotion, StoreDetail storeDetail, String role) {
		super();
		this.store_number = store_number;
		this.store_name = store_name;
		this.kind = kind;
		this.district = district;
		this.store_password = store_password;
		this.promotion = promotion;
		this.storeDetail = storeDetail;
		this.role = role;
	}



	public long getStore_number() {
		return store_number;
	}

	public void setStore_number(long store_number) {
		this.store_number = store_number;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStore_password() {
		return store_password;
	}

	public void setStore_password(String store_password) {
		this.store_password = store_password;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public StoreDetail getStoreDetail() {
		return storeDetail;
	}

	public void setStoreDetail(StoreDetail storeDetail) {
		this.storeDetail = storeDetail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
	
