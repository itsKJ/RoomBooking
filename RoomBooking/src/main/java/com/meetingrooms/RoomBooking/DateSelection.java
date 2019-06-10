package com.meetingrooms.RoomBooking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DateSelection {
	private static boolean error=false;
	static String s;

		public static void dates()
		{
			int i,j = 0;
			
			Scanner sc = new Scanner(System.in);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance(); 
			
			for(i=1;i<=7;i++) //for loop to print 7 days in future
					{
						cal.add(Calendar.DAY_OF_YEAR, 1);
						System.out.println(i+"."+df.format(cal.getTime()));
					}
				
				do{
					try{
						error=false;
			System.out.println("Enter your preferred date: ");
				
			j=sc.nextInt();
			
			if(j>7 || j<1)
				
				if(j>7)
				
					System.out.println("Sorry, you can only select dates upto 7 days in future.");
				
				else
				
					System.out.println("Enter a value from 1 to 7");
					}
					catch(InputMismatchException e)
					{
						error=true;
						System.out.println("Ivalid data, enter a number (1-7)");
						sc.nextLine();
					}
				
				}while(j<1 || j>7 || error==true);
		
				cal = Calendar.getInstance(); //resetting the cal date to today for creating booking id
		
				cal.add(Calendar.DAY_OF_YEAR, j); //getting user selected date
			
				s=df.format(cal.getTime()); //converting into string
		}
}