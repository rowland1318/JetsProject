package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}


	@Override
	public String toString() {
		return "Cargo Plane: " + super.toString();
	} // toString helps display the type of jet

	@Override
	public String loadCargo() {
		return "Loading Cargo. . .";
	}

}
