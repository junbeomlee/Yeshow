package com.jabyun.yeshow.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="busuness")
public class Business {
	
	
	@Id
	@Column(name="business_number")
	private long busuness_number;
	
	@ManyToOne
	@JoinColumn(name="store_number", referencedColumnName="store_number")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name="server_number", referencedColumnName="server_number")
	private Server server;
	
	@Column(name="business_contents")
	private String business_contents;

	public long getBusuness_number() {
		return busuness_number;
	}

	public void setBusuness_number(long busuness_number) {
		this.busuness_number = busuness_number;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public String getBusiness_contents() {
		return business_contents;
	}

	public void setBusiness_contents(String business_contents) {
		this.business_contents = business_contents;
	}

	public Business(){}
	public Business(long busuness_number, Store store, Server server, String business_contents) {
		super();
		this.busuness_number = busuness_number;
		this.store = store;
		this.server = server;
		this.business_contents = business_contents;
	}
	
}
