package com.cmpe295B.healthybites;

import java.io.IOException;

import getRestaurantsData.YelpData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import callYelpApiSerach.SearchRestaurFromYelp;
import getRestaurantsData.Yelp;
import getRestaurantsData.YelpData;

@Controller
@SessionAttributes("user_id")
@RequestMapping("/")


public class HBRSController {
	
    @Autowired private customerDAO customerDAO;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
    
		return "accountlogin";
	}
    
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String verifyLoginAccess(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws NoSuchFieldException{
		String username=request.getParameter("register_username");
		String password=request.getParameter("register_password");

		Customer customer = customerDAO.checkcredentials(username, password);
		if (customer != null)
		{
			//Update the last login time for the user
			String curTimestamp = fetchCurrentTimestamp();
			customerDAO.setLastLogin(customer.getCustomerID(), curTimestamp);
			
			//Set the customer details in the session
			session.setAttribute("user_id", customer.getCustomerID());
			session.setAttribute("register_username", customer.getUsername());
			session.setAttribute("fullname", customer.getFullname());
			session.setAttribute("last_login", customer.getLastLogin());
			session.setAttribute("zip_code", customer.getLastLogin());
			
		
			return "index";
		}
		else
		{	System.out.println("failure");
			return "accountlogin";
		}		
	}
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String NavigateToSignUpAccess(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws NoSuchFieldException
    {   	
    	return "index";
	}
    
    
    @RequestMapping(value = "/Home", method = RequestMethod.GET)
	public String NavigateToLoginPage(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {	//Set a default location for the map to direct
		List<YelpData> list = new ArrayList<YelpData>();
        YelpData yelp1 = new YelpData("",37.33734, -121.89001, "Address-1","zip-1", (float)5, (float)4.0, "Mexican", "64563576872");
        list.add(yelp1);   

       
    	return "index";
    }
    
    @RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String NavigateToLogoutPage(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
    	
    	System.out.println("Withing Logout Function");
    	//Future Work: If you want to handle failures on Logout, this is the place
    	//For time being, this section does nothing much more than closing the session
    	if(customerDAO.logout())
    	{
    		System.out.println("Logout Successful");
    	}
    	else
    	{
    		System.out.println("Logout Failure");
    	}
    	return "accountlogin";
    }
    
    @RequestMapping(value = "/UserAccount", method = RequestMethod.GET)
	public String NavigateTouserAccountPage(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws NoSuchFieldException {
   	int userid=(Integer) session.getAttribute("user_id");
   	
   	//System.out.println("check-----"+userid);
   	Customer cust = customerDAO.viewCustomerProfile(userid);
   	customerprofile profile[]=customerDAO.viewCustomerHealthProfile(userid);
   	model.addAttribute("Customer", cust);
   	model.addAttribute("age", profile[MessageConstants.USER_AGE].getValue());
   	model.addAttribute("bmi_index", profile[MessageConstants.USER_BMI_INDEX].getValue());
   	model.addAttribute("bmi_rating", profile[MessageConstants.USER_BMI_RATING].getValue());
   	model.addAttribute("bp_dia", profile[MessageConstants.USER_BP_DIASTOLIC].getValue());
   	model.addAttribute("bp_sys", profile[MessageConstants.USER_BP_SYSTOLIC].getValue());
   	model.addAttribute("cholestrol", profile[MessageConstants.USER_CHOLESTROL_LDL].getValue());
   	model.addAttribute("diabetic", (int)profile[MessageConstants.USER_DIABETIC].getValue());
   	model.addAttribute("daily_exrcse", (int)profile[MessageConstants.USER_DIALY_EXERCISE].getValue());
   	model.addAttribute("phys_activity", (int)profile[MessageConstants.USER_PHYSICALACTIVITY].getValue());
   	model.addAttribute("gender", profile[MessageConstants.USER_GENDER].getValue());
   	//model.addAttribute("health_rating", profile[MessageConstants.USER_HEALTH_RATING].getValue());
   	model.addAttribute("heart_patient", (int)profile[MessageConstants.USER_HEART_PATIENT].getValue());
   	model.addAttribute("height", profile[MessageConstants.USER_HEIGHT].getValue());
   	model.addAttribute("weight", profile[MessageConstants.USER_WEIGHT].getValue());
   	
   return "useraccount";
   }
    
    
	@RequestMapping(value = "/recommendation", method = RequestMethod.GET)
	public String GetRestaurantRecommendations(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
    	
		
		return "index";
	}
    
    @RequestMapping(value = "/History", method = RequestMethod.GET)
	public String NavigateToHistoryPage(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session)
    {
    	List<UserHistory> historyList = customerDAO.viewCustomerHistory(Integer.parseInt(session.getAttribute("user_id").toString()));
    	model.addAttribute("historyList",historyList);
    	
    	return "history";
	}

    @RequestMapping(value = "/contactus", method = RequestMethod.GET)
	public String NavigateToContactUsPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
    return "contact";
    }
    
    
	public void SaveProfileRequest(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
	    
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String SaveCustomerProfile(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session)
	{
		
		return "index";
	}

	
	private String fetchCurrentTimestamp()
	{
    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    	Date date = new Date();
    	
    	return dateFormat.format(date).toString();
	}
	
}