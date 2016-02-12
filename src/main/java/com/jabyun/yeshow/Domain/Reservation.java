package com.jabyun.yeshow.Domain;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.elasticsearch.common.inject.internal.Nullable;
import org.json.simple.JSONObject;

import com.jabyun.yeshow.Util.Calender;

@Entity
@Table(name="reservation")
public class Reservation {
	
	@Id
	@Column(name="reservation_number")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long reservation_number;
	
	@ManyToOne
	@JoinColumn(name="tokenID", referencedColumnName="tokenID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="store_number", referencedColumnName="store_number")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name="server_number", referencedColumnName="server_number")
	private Server server;
	
	
	@Column(name="reservation_etc")
	private String reservation_etc;
	
	@Column(name="reservation_date")
	private Date reservation_date;
	
	
	@Column(name="reservation_time")
	private Time reservation_time;

	public long getReservation_number() {
		return reservation_number;
	}

	public void setReservation_number(long reservation_number) {
		this.reservation_number = reservation_number;
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

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}
	public String getReservation_etc() {
		return reservation_etc;
	}

	public void setReservation_etc(String reservation_etc) {
		this.reservation_etc = reservation_etc;
	}

	public Date getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(Date reservation_date) {
		this.reservation_date = reservation_date;
	}

	public Time getReservation_time() {
		return reservation_time;
	}

	public void setReservation_time(Time reservation_time) {
		this.reservation_time = reservation_time;
	}
	public Reservation(){}
	public Reservation(long reservation_number, User user, Store store, Server server, String reservation_etc,
			Date reservation_date, Time reservation_time) {
		super();
		this.reservation_number = reservation_number;
		this.user = user;
		this.store = store;
		this.server = server;
		this.reservation_etc = reservation_etc;
		this.reservation_date = reservation_date;
		this.reservation_time = reservation_time;
	}
	
	public Reservation makeReservation(User user,Store store,Server server, Date date, Time time){
		
		this.user=user;
		this.store=store;
		this.server=server;
		this.reservation_date = date;
		this.reservation_time = time;
		
		return this;
	}
}


