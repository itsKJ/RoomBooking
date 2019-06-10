package com.meetingrooms.RoomBooking;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;

public class AlterBooking {
	static void Booking2() {
	boolean error = App.error; 
	char again = App.again;
	int cont = App.cont;
	int s;
	Scanner sc = new Scanner(System.in);
		

		
		
		do{
		
		System.out.println("Enter your booking ID :");
		
		s=sc.nextInt();
		
		error=false;
		
		try{ //try block to check booking clash
			
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(App.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		App app = (App) session.get(App.class,s);
		
		System.out.println("Booking ID : "+app.ID);
		
		Name.getname();
		DateSelection.dates();
		Rooms.getRoom();
		SlotBooking.slot();
		
		
		 app.day=DateSelection.s;
		 app.name =Name.name;
		 app.slot =SlotBooking.s;
		 app.room =Rooms.r;
		 app.unique_code= app.day+"-r"+Rooms.k+"-s"+SlotBooking.j;
		
		
			System.out.println("\n\nPreferred date is "+app.day);
			System.out.println("Given name is "+app.name);
			System.out.println("Preferred room is "+app.room );
			System.out.println("Preferred slot is "+app.slot);
			System.out.println("Unique code - "+app.unique_code);
			
		
		session.save(app);
		
		tx.commit();
		
		}
		
		catch (ConstraintViolationException ex)
		{
		    
		    System.out.println("Sorry, requested room already booked. Do you want to try again?(Y/N)");
		    
		    again=sc.next().charAt(0);
		    
		    error=true; //flag variable used for booking clash
		}
		if (error==false){

			System.out.println("\nRoom booking edit successful!\n");
		}
		
		}while(error==true&& (again=='Y'||again=='y')); //goes back to user inputs except name
		
		
		System.out.println("Thank you!\n\n"); //exits program
		}
}