package com.meetingrooms.RoomBooking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SlotBooking {
	private static boolean error=false;
	static String s;
	static int j;
	
	static public void slot(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 9 am to 12 pm \n2. 12 pm to 3 pm \n3. 3 pm to 6 pm\n");
		do{
			try{
				error=false;
		System.out.println("Enter your preferred time slot: ");
		j=sc.nextInt();
		if(j>3 || j<1)
			System.out.println("Invalid data, enter a value between 1 to 3");
			}
			catch(InputMismatchException e)
			{
				error=true;
				System.out.println("Ivalid data, enter a number (1-3)");
				sc.nextLine();
			}
		}while(j<1 || j>3);
		if (j==1)
				s="9 am to 12 pm";
		if (j==2)
				s="12 pm to 3 pm";
		if (j==3)
				s="3 pm to 6 pm";
	}
}
