package com.cmpe295B.healthybites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_recommendations")
public class userRecommend implements Serializable{
	
	@Id
	@Column(name="u_id")
	private int customerID;
	
	@Id
	@Column(name="reco_place")
	private String recommendPlace;
	
	@Column(name="reco_cuisine")
	private String recommendCuisine;
	
	@Column(name="reco_rating")
	private float recommendRating;

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getRecommendPlace() {
		return recommendPlace;
	}

	public void setRecommendPlace(String recommendPlace) {
		this.recommendPlace = recommendPlace;
	}

	public String getRecommendCuisine() {
		return recommendCuisine;
	}

	public void setRecommendCuisine(String recommendCuisine) {
		this.recommendCuisine = recommendCuisine;
	}

	public float getRecommendRating() {
		return recommendRating;
	}

	public void setRecommendRating(float recommendRating) {
		this.recommendRating = recommendRating;
	}
	}
