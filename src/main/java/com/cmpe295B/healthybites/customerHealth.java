package com.cmpe295B.healthybites;

public class customerHealth {
	
	
	
	int age;
//	Date dateOfBirth;
	String gender;
	float height;	//In centimeters
	float weight;
	boolean diabetic;
	boolean heartPatient;

//BMI Parameters
	float bmiIndex;
	String bmiRating;

//Blood Pressure
	int bpSystolic;		//Upper(120)
	int bpDiastolic;	//Lower(80)
	int cholestrolLDL;
	int dailyExercise;
	int healthRating;

	
	//Additional Info
	int physicalExercise;

	public customerHealth()
	{
		this.age=0;
		this.gender=null;
		this.height=0;
		this.weight=0;
		this.bmiIndex=0;
		this.bmiRating="Normal Weight";
		
		//Blood Pressure
		this.bpSystolic=120;
		this.bpDiastolic=80;
		
		//Diabetes
		this.diabetic=false;
		
		
		//Cholestrol & Heart
		this.cholestrolLDL=120;
		this.heartPatient=false;
		
		
		this.physicalExercise=0;
	
		this.dailyExercise=0;
		

	}
	
	
	
	

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public float getHeight() {
		return height;
	}


	public void setHeight(float height) {
		this.height = height;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}


	public boolean isDiabetic() {
		return diabetic;
	}


	public void setDiabetic(boolean diabetic) {
		this.diabetic = diabetic;
	}


	public boolean isHeartPatient() {
		return heartPatient;
	}


	public void setHeartPatient(boolean heartPatient) {
		this.heartPatient = heartPatient;
	}


	public float getBmiIndex() {
		return bmiIndex;
	}


	public void setBmiIndex(float bmiIndex) {
		this.bmiIndex = bmiIndex;
	}


	public String getBmiRating() {
		return bmiRating;
	}


	public void setBmiRating(String bmiRating) {
		this.bmiRating = bmiRating;
	}


	public int getBpSystolic() {
		return bpSystolic;
	}


	public void setBpSystolic(int bpSystolic) {
		this.bpSystolic = bpSystolic;
	}


	public int getBpDiastolic() {
		return bpDiastolic;
	}


	public void setBpDiastolic(int bpDiastolic) {
		this.bpDiastolic = bpDiastolic;
	}


	public int getCholestrolLDL() {
		return cholestrolLDL;
	}


	public void setCholestrolLDL(int cholestrolLDL) {
		this.cholestrolLDL = cholestrolLDL;
	}


	public int getDailyExercise() {
		return dailyExercise;
	}


	public void setDailyExercise(int dailyExercise) {
		this.dailyExercise = dailyExercise;
	}


	public int getHealthRating() {
		return healthRating;
	}


	public void setHealthRating(int healthRating) {
		this.healthRating = healthRating;
	}


	public int getPhysicalExercise() {
		return physicalExercise;
	}


	public void setPhysicalExercise(int physicalExercise) {
		this.physicalExercise = physicalExercise;
	}
	
}
	
	

