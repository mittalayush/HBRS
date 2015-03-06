package com.cmpe295B.healthybites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_history")
public class UserHistory implements Serializable
{
	@Column(name="u_id")
	int userid;
	
	@Column(name="reco_time")
	String recoTime;
	
	@Id
	@Column(name="reco_placeId")
	int recoPlaceId;
	
	@Column(name="reco_place")
	String recoPlace;
	
	@Column(name="reco_cuisine")
	String recoCuisine;
	
	@Column(name="reco_foodItem")
	String recoFoodItem;
	
	@Column(name="reco_rating")
	float recoRating;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getRecoTime() {
		return recoTime;
	}

	public void setRecoTime(String recoTime) {
		this.recoTime = recoTime;
	}

	public int getRecoPlaceId() {
		return recoPlaceId;
	}

	public void setRecoPlaceId(int recoPlaceId) {
		this.recoPlaceId = recoPlaceId;
	}

	public String getRecoPlace() {
		return recoPlace;
	}

	public void setRecoPlace(String recoPlace) {
		this.recoPlace = recoPlace;
	}

	public String getRecoCuisine() {
		return recoCuisine;
	}

	public void setRecoCuisine(String recoCuisine) {
		this.recoCuisine = recoCuisine;
	}

	public String getRecoFoodItem() {
		return recoFoodItem;
	}

	public void setRecoFoodItem(String recoFoodItem) {
		this.recoFoodItem = recoFoodItem;
	}

	public float getRecoRating() {
		return recoRating;
	}

	public void setRecoRating(float recoRating) {
		this.recoRating = recoRating;
	}
}
