package com.cmpe295B.healthybites;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "calorie_map")
public class CalorieMap implements Serializable
{
	@Id
	@Column(name="type")
	int type;
	
	@Id
	@Column(name="minTime")
	Time minTime;

	@Id
	@Column(name="maxTime")
	Time maxTime;

	@Column(name="calorieCap")
	int calorieCap;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Time getMinTime() {
		return minTime;
	}

	public void setMinTime(Time minTime) {
		this.minTime = minTime;
	}

	public Time getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(Time maxTime) {
		this.maxTime = maxTime;
	}

	public int getCalorieCap() {
		return calorieCap;
	}

	public void setCalorieCap(int calorieCap) {
		this.calorieCap = calorieCap;
	}
}
