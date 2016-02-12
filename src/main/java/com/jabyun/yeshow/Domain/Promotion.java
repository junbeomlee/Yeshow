package com.jabyun.yeshow.Domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Promotion {
	

	@Column(name="promotion_contents")
	private String promotion_contents;
	
	@Column(name="promotion_name")
	private String promotion_name;
	
	
	public Promotion(){}

	

	public Promotion(String promotion_contents, String promotion_name) {
		super();
		this.promotion_contents = promotion_contents;
		this.promotion_name = promotion_name;
	}



	public String getPromotion_contents() {
		return promotion_contents;
	}

	public void setPromotion_contents(String promotion_contents) {
		this.promotion_contents = promotion_contents;
	}

	public String getPromotion_name() {
		return promotion_name;
	}

	public void setPromotion_name(String promotion_name) {
		this.promotion_name = promotion_name;
	}
	
}
