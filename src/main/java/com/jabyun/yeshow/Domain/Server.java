package com.jabyun.yeshow.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="server")
public class Server {
	
	@Id
	@Column(name="server_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long server_number;
	
	@OneToOne
	@JoinColumn(name="store_number", referencedColumnName="store_number")
	private Store store;
	
	@Column(name="server_name")
	private String server_name;
	
	@Column(name="server_offtime")
	private String server_offtime;
	
	@Column(name="server_phone")
	private String server_phone;
	
	@Column(name="server_etc")
	private String server_etc;
	
	@Column(name="server_age")
	private Integer server_age;
	
	public Integer getServer_age() {
		return server_age;
	}

	public void setServer_age(Integer server_age) {
		this.server_age = server_age;
	}

	public Server(){}
	
	public Server(long server_number, Store store, String server_name, String server_offtime, String server_phone,
			String server_etc, Integer server_age) {
		super();
		this.server_number = server_number;
		this.store = store;
		this.server_name = server_name;
		this.server_offtime = server_offtime;
		this.server_phone = server_phone;
		this.server_etc = server_etc;
		this.server_age = server_age;
	}

	public Server(Store store, String server_name, String server_offtime, String server_phone,
			String server_etc) {
		super();
		this.store = store;
		this.server_name = server_name;
		this.server_offtime = server_offtime;
		this.server_phone = server_phone;
		this.server_etc = server_etc;
	}
	

	public Server(Store store, String server_name, String server_offtime, String server_phone,
			String server_etc, int server_age) {
		super();
		this.store = store;
		this.server_name = server_name;
		this.server_offtime = server_offtime;
		this.server_phone = server_phone;
		this.server_etc = server_etc;
		this.server_age = server_age;
	}

	public String getServer_phone() {
		return server_phone;
	}


	public void setServer_phone(String server_phone) {
		this.server_phone = server_phone;
	}


	public String getServer_etc() {
		return server_etc;
	}


	public void setServer_etc(String server_etc) {
		this.server_etc = server_etc;
	}


	public long getServer_number() {
		return server_number;
	}

	public void setServer_number(long server_number) {
		this.server_number = server_number;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getServer_name() {
		return server_name;
	}

	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}

	public String getServer_offtime() {
		return server_offtime;
	}

	public void setServer_offtime(String server_offtime) {
		this.server_offtime = server_offtime;
	}
}
