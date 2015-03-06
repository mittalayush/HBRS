package com.cmpe295B.healthybites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "food_nutrition")
public class FoodNutrition implements Serializable
{
	@Id
	@Column(name="food_id")
	int food_id;
	
	@Column(name="calories")
	int calories;

	@Column(name="fat")
	int fat;
	
	@Column(name="cholestrol")
	int cholestrol;
	
	@Column(name="sodium")
	int sodium;
	
	@Column(name="carbs")
	int carbs;
	
	@Column(name="protein")
	int protein;
	
	@Column(name="sugar")
	int sugar;
	
	@Column(name="fiber")
	int fiber;
	
	@Column(name="cuisine")
	String cuisine;

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getCholestrol() {
		return cholestrol;
	}

	public void setCholestrol(int cholestrol) {
		this.cholestrol = cholestrol;
	}

	public int getSodium() {
		return sodium;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public int getCarbs() {
		return carbs;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	public int getFiber() {
		return fiber;
	}

	public void setFiber(int fiber) {
		this.fiber = fiber;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
}
