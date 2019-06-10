package com.meetingrooms.RoomBooking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rooms {
	private static boolean error=false;
	static String r;
	static int k;
	public static void getRoom(){
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("1.Room#1\n2.Room#2\n3.Room#3\n4.Room#4\n5.Room#5\n");
		do{
			 
			try{
				error=false;
			System.out.println("Enter your preferred room\n");
			
			k=sc.nextInt();
			
			if(k>5 || k<1)
				System.out.println("Invalid data, enter a value between 1 to 5");
			}
			catch(InputMismatchException e)
			{
				error=true;
				System.out.println("Ivalid data, enter a number (1-5)");
				sc.nextLine();
			}
		}while(k<1 || k>5 || error==true);
	if (k==1)
			r="Room#1";
	else if (k==2)
			r="Room#2";
	else if (k==3)
			r="Room#3";
	else if (k==4)
			r="Room#4";
	else if (k==5)
			r="Room#5";
		
		
	}
}
