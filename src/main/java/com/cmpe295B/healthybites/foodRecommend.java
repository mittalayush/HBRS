package com.cmpe295B.healthybites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "food_recommendations")
public class foodRecommend implements Serializable
{
	
	@Id
	@Column(name="food_id")
	private int foodID;
	
	@Id
	@Column(name="reco_food_id")
	private int recoFoodID;
	
	@Column(name="reco_food_name")
	private String recoFoodName;

	public int getFoodID() {
		return foodID;
	}

	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}

	public int getRecoFoodID() {
		return recoFoodID;
	}

	public void setRecoFoodID(int recoFoodID) {
		this.recoFoodID = recoFoodID;
	}

	public String getRecoFoodName() {
		return recoFoodName;
	}

	public void setRecoFoodName(String recoFoodName) {
		this.recoFoodName = recoFoodName;
	}

}
