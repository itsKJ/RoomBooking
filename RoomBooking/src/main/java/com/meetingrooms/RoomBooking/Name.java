package com.meetingrooms.RoomBooking;

import java.util.Scanner;

public class Name {
	
	static String name;
	 
	static public void getname (){
		
		Scanner sc = new Scanner(System.in);
		
		do{
		
			System.out.println("Enter your team name :");
		
			name = sc.next();
		
		}while(name==null);
		
	}
}