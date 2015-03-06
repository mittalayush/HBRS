package com.cmpe295B.healthybites;
import java.io.Serializable;

@SuppressWarnings("serial")
// error or success messages to be displayed
public class MessageConstants implements Serializable
{
	//Parameters for User Health Profile
//	public static final int USER_ID = 1;
	public static final int USER_AGE = 1;
	public static final int USER_GENDER = 2;
	public static final int USER_HEIGHT = 3;
	public static final int USER_WEIGHT = 4;
	public static final int USER_BMI_INDEX = 5;
	public static final int USER_BMI_RATING = 6;
	public static final int USER_BP_SYSTOLIC = 7;
	public static final int USER_BP_DIASTOLIC = 8;
	public static final int USER_DIABETIC = 9;
//	public static final int USER_DIABETIC_HISTORY = 11;
	public static final int USER_CHOLESTROL_LDL = 10;
	public static final int USER_HEART_PATIENT = 11;
	public static final int USER_PHYSICALACTIVITY = 12;
	public static final int USER_DIALY_EXERCISE = 13;
	public static final int USER_HEALTH_RATING = 14;
	
	//Parameters for User Health Rating
	public static final int USER_NOT_FIT = 1;
	public static final int USER_MODERATE = 2;
	public static final int USER_FIT = 3;
	
	//Parameters for Food Nutrition Values
	public static final int FOOD_CALORIES = 1;
	public static final int FOOD_FATS = 2;	
	public static final int FOOD_CHOLESTROL = 3;
	public static final int FOOD_SODIUM = 4;
	public static final int FOOD_CARBS = 5;
	public static final int FOOD_PROTEIN = 6;
	public static final int FOOD_SUGAR = 7;
	public static final int FOOD_FIBER = 8;
	public static final int FOOD_CUISINE = 9;
}
