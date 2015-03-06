package com.cmpe295B.healthybites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "nutrition_map")
public class NutritionMap implements Serializable
{
	@Id
	@Column(name="type")
	int type;
	
	@Column(name="fatCap")
	int fatCap;

	@Column(name="cholestrolCap")
	int cholestrolCap;
	
	@Column(name="sodiumCap")
	int sodiumCap;
	
	@Column(name="carbCap")
	int carbCap;
	
	@Column(name="proteinCap")
	int proteinCap;
	
	@Column(name="sugarCap")
	int sugarCap;
	
	@Column(name="fiberCap")
	int fiberCap;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getFatCap() {
		return fatCap;
	}

	public void setFatCap(int fatCap) {
		this.fatCap = fatCap;
	}

	public int getCholestrolCap() {
		return cholestrolCap;
	}

	public void setCholestrolCap(int cholestrolCap) {
		this.cholestrolCap = cholestrolCap;
	}

	public int getSodiumCap() {
		return sodiumCap;
	}

	public void setSodiumCap(int sodiumCap) {
		this.sodiumCap = sodiumCap;
	}

	public int getCarbCap() {
		return carbCap;
	}

	public void setCarbCap(int carbCap) {
		this.carbCap = carbCap;
	}

	public int getProteinCap() {
		return proteinCap;
	}

	public void setProteinCap(int proteinCap) {
		this.proteinCap = proteinCap;
	}

	public int getSugarCap() {
		return sugarCap;
	}

	public void setSugarCap(int sugarCap) {
		this.sugarCap = sugarCap;
	}

	public int getFiberCap() {
		return fiberCap;
	}

	public void setFiberCap(int fiberCap) {
		this.fiberCap = fiberCap;
	}
}
