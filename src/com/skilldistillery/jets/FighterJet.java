package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);

	}

	@Override
	public String toString() {
		return "Fighter Jet: " + super.toString();
	} // toString helps display the type of jet

	@Override
	public String fight() {
		return "Ready to fight!";
	}

}
