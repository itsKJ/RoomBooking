package com.meetingrooms.RoomBooking;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class StatusCheck {
	static int s;
	static Scanner sc = new Scanner(System.in);
	static boolean error = false;
	public static void getStatus(){
	System.out.println("Enter your booking ID :");
	
	s=sc.nextInt();
	
	error=false;
	
	try{ //try block to check booking clash
		
	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(App.class);
	
	SessionFactory sf = con.buildSessionFactory();
	
	Session session = sf.openSession();
	
	org.hibernate.Transaction tx = session.beginTransaction();
	
	App app = (App) session.get(App.class,s);
	
	
	System.out.println("\n=================================");
	System.out.println("Preferred date is :"+app.day);
	System.out.println("Given name is 	  :"+app.name);
	System.out.println("Preferred room is :"+app.room );
	System.out.println("Preferred slot is :"+app.slot);
	//System.out.println("Unique code 	  :"+app.unique_code);
	System.out.println("=================================\n");
	
	tx.commit();
	
	}
	catch(java.lang.NullPointerException e)
	{
		System.out.println("The given booking ID doesnot exist!");
	}

}
}
