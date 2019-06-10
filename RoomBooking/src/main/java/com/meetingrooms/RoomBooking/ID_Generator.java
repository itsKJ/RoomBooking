package com.meetingrooms.RoomBooking;
import java.util.Random;
public class ID_Generator {
	
	static int BookingID;
	
static int getID(){
	Random rand = new Random();
	BookingID = rand.nextInt(99999);
	return BookingID;
}
}
