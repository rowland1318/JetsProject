package com.skilldistillery.jets;

import java.text.DecimalFormat;

public abstract class Jet {

	// F I E L D S
	private String model;
	private double speed;
	private int range;
	private long price;

	// C O N S T R U C T O R
	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	// M E T H O D S
	public void fly() {
		DecimalFormat df = new DecimalFormat("#.##");
		double flightFormula = range / speed;
		String flightFormulaFormat = df.format(flightFormula);
		System.out.println(this.getModel() + " is flying with " + flightFormulaFormat + " hours left");
	};

	public String getSpeedinMach() {
		DecimalFormat df = new DecimalFormat("#.###");
		double machSpeed = speed / 767;
		String machSpeedFormat = df.format(machSpeed);
		return machSpeedFormat;
	}

	// G E T T E R S  &  S E T T E R S
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	// T O  S T R I N G
	@Override
	public String toString() {
		return "Model: " + model + ", Speed: " + speed + ", Mach Speed: " + getSpeedinMach() + ", Range: " + range
				+ ", Price: " + price;
	}

	// H A S H C O D E  &  E Q U A L S
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + range;
		long temp;
		temp = Double.doubleToLongBits(speed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		if (range != other.range)
			return false;
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
			return false;
		return true;
	}

}
