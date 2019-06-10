package com.meetingrooms.RoomBooking;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Del {
public static void delete(){
	int s = 0;
	char warn;
	
	
	Scanner sc=new Scanner(System.in);
	

	
	System.out.println("Enter your booking ID to delete : ");
	s=sc.nextInt();
	
	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(App.class);
	
	SessionFactory sf = con.buildSessionFactory();
	
	Session session = sf.openSession();
	
	org.hibernate.Transaction tx = session.beginTransaction();
	
	App app = (App) session.get(App.class,s);
	
	System.out.println("It is an irreversible process, are you sure want to delete booking "+app.ID+" ?"+"(Y/N)");
	
	warn=sc.next().charAt(0);
	
	if(warn=='Y'||warn=='y')
	{
		
	session.delete(app);
	tx.commit();
	System.out.println("Delete Successful");
	
	}
	else
	{
		System.out.println("Delete aborted!");
	}
	}
	
	
}
