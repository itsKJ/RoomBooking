package com.meetingrooms.RoomBooking;


import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;




@javax.persistence.Entity 
public class App {
	public String day, name,slot,room;
	@Id 
	public int ID;
	@Column(unique = true)
	public String unique_code;
	public static boolean error=false;
	public static char again;
	static Scanner sc = new Scanner(System.in);
	public static char cont;
	
	
	static void newBooking() {
		
		
		App app = new App();
		
	
			Name.getname();
			app.name =Name.name;
			app.ID=ID_Generator.getID();
			
	
			Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(App.class);
			
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
				
			SessionFactory sf = con.buildSessionFactory(reg);
			
		
		do{
		
		
			
		
		DateSelection.dates();
		Rooms.getRoom();
		SlotBooking.slot();
		
		
		 app.day=DateSelection.s;
		 app.slot =SlotBooking.s;
		 app.room =Rooms.r;
		 app.unique_code= app.day+"-r"+Rooms.k+"-s"+SlotBooking.j;
					
			
		 Session session = sf.openSession();
		
		try{ //try block to check booking clash
			
		Transaction tx = session.beginTransaction();
		
		session.save(app);
		
		tx.commit();
		
		session.close();
			
		
		error=false;
		
		
		
		}
		
		catch (ConstraintViolationException ex)
		{
			session.close();
			
		    System.out.println("Sorry, requested room already booked. Do you want to try again?(Y/N)");
		    
		    again=sc.next().charAt(0);
		    
		    error=true; //flag variable used for booking clash
		    
		    
		}
		
		if (error==false){
			System.out.println("\n\nPreferred date is :"+app.day);
			System.out.println("Given name is :"+app.name);
			System.out.println("Preferred room is :"+app.room );
			System.out.println("Preferred slot is :"+app.slot);
			System.out.println("Unique code :"+app.unique_code);
			System.out.println("======================================================");
			System.out.println("Note down your booking ID for future Reference - "+app.ID);
			System.out.println("======================================================");
			System.out.println("Room booking successful!");
		}
	
		
		}while(error==true&& (again=='Y'||again=='y')); //goes back to user inputs except name
		
	
	
		
		System.out.println("Thank you!\n\n"); //exits program
		
	}
	
	}