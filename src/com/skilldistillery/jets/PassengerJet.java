package com.skilldistillery.jets;

public class PassengerJet extends Jet {

	public PassengerJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}


	@Override
	public String toString() {
		return "Passenger Jet: " + super.toString();
	} // toString helps display the type of jet

}
