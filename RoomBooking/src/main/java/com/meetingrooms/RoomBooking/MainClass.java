package com.meetingrooms.RoomBooking;

import java.util.Scanner;

public class MainClass 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
	boolean error=false;;	
	int selection = 0;
	do
	{
		error=false;
		
		do
		{
			System.out.println("Welcome, select your required service\n\n");
			System.out.println("1.New Booking\n\n2.Alter old booking\n\n3.Delete Booking\n\n4.status check\n\n5.Exit");
			error=false;
			try
			{
				selection = sc.nextInt();
				switch (selection){
				case 1:
				{
					App.newBooking();
					Scanner sc  = new Scanner(System.in);
					System.out.println("Press Enter to continue...");
					sc.nextLine();
					break;
				}
				case 2:
					{
						try
							{
								AlterBooking.Booking2();
								Scanner sc  = new Scanner(System.in);
								System.out.println("Press Enter to continue...");
								sc.nextLine();
								break;
							}
						catch(java.lang.NullPointerException e)
							{
									System.out.println("The given booking ID doesnot exist!");
							}
					}
				case 3:
					{
						try
							{
								Del.delete();
								Scanner sc  = new Scanner(System.in);
								System.out.println("Press Enter to continue...");
								sc.nextLine();
								break;
							}
						catch(java.lang.NullPointerException e)
							{
								System.out.println("The given booking ID doesnot exist!");
							}
					}
				
				case 4:
				{
					StatusCheck.getStatus();
					Scanner sc  = new Scanner(System.in);
					System.out.println("Press Enter to continue...");
					sc.nextLine();
					break;
				}
						
				case 5:
							{
								System.out.println("Thank-you!");
								break;
							}
			
				default:
						{
							System.out.println("Enter a number between 1-5\n");
						}
					}
			}
			
				catch(java.util.InputMismatchException e)
						{
							error=true;
							System.out.println("Invalid input, Enter a number\n");
							sc.nextLine();
						}
					
		}while(error=false);
		
	}while(selection!=5);
	
	
					
				
	}
	
}
