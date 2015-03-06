package com.cmpe295B.healthybites;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SuppressWarnings({"unchecked", "rawtypes"})

public class customerDAO {

	@Autowired private SessionFactory sessionFactory;
	@Transactional
	public Customer checkcredentials(String username, String password)
	{
		Session session = sessionFactory.getCurrentSession();
		List pwd = session.createQuery("from Customer where username='"+username+"'"+ " and password='"+password+"'").list();
		Customer customer = null;

		try
		{
			if(!pwd.isEmpty())		customer = (Customer)pwd.get(0);
			else					customer = null;
			
		} catch (SecurityException e)	{e.printStackTrace();}

		return customer;
	}	
	
	@Transactional
	public int RegisterCustomer(Customer customer)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(customer);  
		session.getTransaction().commit();
		
		List list = session.createQuery("select customerID from Customer where username='"+customer.getUsername()+"'").list();
		session.close();
		
		Iterator<Object> litr = list.iterator();
		int u_id = 0;
		
		while(litr.hasNext())
		{
			u_id = Integer.parseInt(litr.next().toString());
			break;
        }

		return u_id;
	}
	
	@Transactional
	public void RegisterProfile(customerprofile[] profile)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for(int i=1; i<=14; i++)
		{
			session.save(profile[i]);
		}
		session.getTransaction().commit();
	}
	
	public Customer viewCustomerProfile(int u_id)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List list = session.createQuery("from Customer where u_id='"+u_id+"'").list();
		Customer customer = (Customer)list.get(0);
		session.close();
		
	    return customer;
	}
	
	public customerprofile[] viewCustomerHealthProfile(int u_id)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		customerprofile[] profile = new customerprofile[20];
		List list = session.createQuery("from customerprofile where u_id='"+u_id+"'").list();
		Iterator<Object> litr = list.iterator();
		int count=1;
		while(litr.hasNext()){
		profile[count++]= (customerprofile) (litr.next());
		}
		session.close();
	    return profile;
	}
	
	
	
	
	public List<UserHistory> viewCustomerHistory(int u_id)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<UserHistory> list = session.createQuery("from UserHistory where userid="+u_id).list();
		
		return list;
	}
	
	public boolean logout()
	{
		try
		{
			Session session = sessionFactory.openSession();
			
			session.clear();
			session.close();
			
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	
	
	public List<foodRecommend> getRecoFoodIDs(int food_id)
	{
	   	Session session = sessionFactory.openSession();
	   	session.beginTransaction();
	   	
        List<foodRecommend> recoFoodIDList = session.createQuery("from foodRecommend where foodID="+food_id).list();
        return recoFoodIDList;
	}
	


	

	public void setLastLogin(int customerID,String lastLogin)
	{
		Session session = sessionFactory.openSession();

		session.getTransaction().begin();

		Query query = session.createQuery("update Customer set u_lastLogin='"+lastLogin+"' where u_id="+customerID);
		query.executeUpdate();
		
		

		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	

	
	public int getFoodID(String foodName)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List list = session.createQuery("select food_id from food_items where food_name='"+foodName+"'").list();

		Object[] obj = (Object[])list.get(0);
		session.close();
		
	    return Integer.parseInt(obj[0].toString());
	}
	
	
}
