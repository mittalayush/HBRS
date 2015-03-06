package com.cmpe295B.healthybites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "USER_PROFILE")
public class customerprofile implements Serializable
{
	public customerprofile(int u_id, int param, float value)
	{
		this.u_id = u_id;
		this.param = param;
		this.value = value;
	}
	
	public customerprofile()
	{
		this.u_id = 0;
		this.param = 0;
		this.value = 0;
	}
	
	@Id
	@Column(name="u_id")
	private int u_id;
	
	@Id
	@Column(name="param")
	private int param;
	
	@Column(name="value")
	private float value;

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getParam() {
		return param;
	}

	public void setParam(int param) {
		this.param = param;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}


}
