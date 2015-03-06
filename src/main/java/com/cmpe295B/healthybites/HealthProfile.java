
package com.cmpe295B.healthybites;
import java.io.Serializable;


public class HealthProfile implements Serializable
{

	private static final long serialVersionUID = 1L;

	//General Params
	int age;
//	Date dateOfBirth;
	String gender;
	float height;	//In centimeters
	float weight;	//In Pounds (Lbs)
	
	//BMI Parameters
	float bmiIndex;
	String bmiRating;
	
	//Blood Pressure
	int bpSystolic;		//Upper(120)
	int bpDiastolic;	//Lower(80)
	
	//Diabetes
	boolean diabetic;
	boolean diabeticHistory;
	
	//Cholestrol & Heart
	int cholestrolLDL;
	boolean heartPatient;
	
	//Additional Info
	int physicalActivity;
	int dailyExercise;
	
	public HealthProfile()
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
		this.diabeticHistory=false;
		
		//Cholestrol & Heart
		this.cholestrolLDL=120;
		this.heartPatient=false;
		
		/*
		 * List of possible options for Physical Activity
		 * Sedentary = 1
		 * Moderate = 2
		 * Active = 3
		 */
		this.physicalActivity=0;
		
		/*
		 * List of possible options for Daily Exercise
		 * Never = 1
		 * Often = 2
		 * Regularly = 3
		 */
		this.dailyExercise=0;
		
		//Compute the BMI parameters
//		computeBMIParams();
	}
	
	//Getters
	public int getAge()					{return this.age;}
//	public Date getDateOfBirth()		{return dateOfBirth;}
	public String getGender()			{return this.gender;}
	public float getHeight()			{return this.height;}
	public float getWeight()			{return this.weight;}

	public int getBpSystolic()			{return this.bpSystolic;}
	public int getBpDiastolic()			{return this.bpDiastolic;}

	public boolean getDiabetic()		{return this.diabetic;}
	public boolean getDiabeticHistory()	{return this.diabeticHistory;}

	public int getCholestrolLDL()		{return this.cholestrolLDL;}
	public boolean getHeartPatient()	{return this.heartPatient;}
	
	public int getPhysicalActivity()	{return this.physicalActivity;}
	public int getDailyExercise()		{return this.dailyExercise;}
	
	//Setters
	public void setAge(int age)						{this.age=age;}
	public void setGender(String gender)			{this.gender=gender;}
	public void setHeight(float height)				{this.height=height;}
	public void setWeight(float weight)				{this.weight=weight;}

	public void setBpSystolic(int bpSystolic)		{this.bpSystolic=bpSystolic;}
	public void setBpDiastolic(int bpDiastolic)		{this.bpDiastolic=bpDiastolic;}

	public void setDiabetic(boolean diabetic)	{this.diabetic=diabetic;}
	public void setDiabeticHistory(boolean diabeticHistory)		{this.diabeticHistory=diabeticHistory;}

	public void setCholestrolLDL(int cholestrolLDL)				{this.cholestrolLDL=cholestrolLDL;}
	public void setHeartPatient(boolean heartPatient)			{this.heartPatient=heartPatient;}
	
	public void setPhysicalActivity(int physicalActivity)		{this.physicalActivity=physicalActivity;}
	public void setDailyExercise(int dailyExercise)				{this.dailyExercise=dailyExercise;}
	


	private float getHeightInMeters()	{return (this.height/100);}
	private float getWeightInKilo()		{return (float) (this.weight*0.453592);}
}