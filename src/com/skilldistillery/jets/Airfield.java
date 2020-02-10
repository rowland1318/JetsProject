package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Airfield {

	// F I E L D S

	private List<Jet> jet = new ArrayList<>();
	private Scanner kb = new Scanner(System.in);

	// M E T H O D S

	public Airfield() {
		readAndPopulateFromFile();
	}

	public void flyAllJets() {
		for (Jet jetFly : jet) {
			jetFly.fly();
		}
	}

	public String viewFastestJet() {
		double currentSpeed = Double.MIN_VALUE;
		String fastest = null;
		for (Jet jetFast : jet) {
			if (jetFast.getSpeed() > currentSpeed) {
				currentSpeed = jetFast.getSpeed();
				fastest = jetFast.toString();
			}

		}
		return fastest;
	}

	public String viewLongestRange() {
		double currentRange = Double.MIN_VALUE;
		String longest = null;
		for (Jet jetLong : jet) {
			if (jetLong.getRange() > currentRange) {
				currentRange = jetLong.getRange();
				longest = jetLong.toString();

			}
		}
		return longest;
	}

	public void loadCargoPlanes() {
		for (Jet currentJet : jet) {
			if (currentJet instanceof CargoPlane) {
				CargoPlane planeWithCargo = ((CargoPlane) currentJet);
				System.out.println("Looking at: " + planeWithCargo.toString());
				System.out.println(planeWithCargo.loadCargo());
			}
		}
	}

	public void dogFight() {
		for (Jet currentJet : jet) {
			if (currentJet instanceof FighterJet) {
				FighterJet planeCanFight = ((FighterJet) currentJet);
				System.out.println("Looking at: " + planeCanFight.toString());
				System.out.println(planeCanFight.fight());
			}

		}
	}

	public void addJet() {
		System.out.println("What type of jet would you like to add to your airfield?");
		System.out.println("1. Fighter Jet");
		System.out.println("2. Cargo Plane");
		System.out.println("3. Passenger Jet");
		

		int planeType = kb.nextInt();
//		if (planeType < 1 || planeType >3){
//			System.out.println("Number Not Recognized! Please Select a Menu Item Between 1 and 3:");
//		}
		
		kb.nextLine();
		System.out.print("Enter the model of the Jet: ");
		String model = kb.nextLine();
		System.out.print("Enter the top speed of the Jet: ");
		double speed = kb.nextDouble();
		System.out.print("Enter the range of the Jet: ");
		int range = kb.nextInt();
		System.out.print("Enter the price of the Jet: ");
		long price = kb.nextLong();
		kb.nextLine();

//		if (!fault) {

			if (planeType == 1) {
				FighterJet fighterJet = new FighterJet(model, speed, range, price);
				jet.add(fighterJet);
				System.out.println("You have added a " + fighterJet.getModel() + " " + fighterJet.getClass().getSimpleName() + " to your Airfield.");
			} else if (planeType == 2) {
				CargoPlane cargoPlane = new CargoPlane(model, speed, range, price);
				jet.add(cargoPlane);
				System.out.println("You have added a " + cargoPlane.getModel() + " " +cargoPlane.getClass().getSimpleName() + " to your Airfield.");
			} else if (planeType == 3) {
				JetImpl jetImpl = new JetImpl(model, speed, range, price);
				jet.add(jetImpl);
				System.out.println("You have added a " + jetImpl.getModel() + " " + jetImpl.getClass().getSimpleName() + " to your Airfield.");
			} else {
				System.out.println("Number Was Not Recognized for Jet Selection! Jet Was Not Added!");
			}
		}
		
//		
//		}
	

	public void removeJet() {

		System.out.println("Please select the number associated with the jet that you would like to remove: ");
		for (int index = 0; index < jet.size(); index++) {
			System.out.println((index + 1) + ". " + jet.get(index));
		}

		int userInput = kb.nextInt();
		Jet removedJet = jet.remove(userInput - 1);
		System.out.println(removedJet.getModel() + " " + "was removed");
	}

	public List<Jet> readAndPopulateFromFile() {
		try {
			FileReader fr = new FileReader("jets.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				String type = fields[0].trim();
				String model = fields[1].trim();
				double speed = Double.parseDouble(fields[2].trim());
				int range = Integer.parseInt(fields[3].trim());
				long price = Long.parseLong(fields[4].trim());
				if (type.contentEquals("FighterJet")) {
					jet.add(new FighterJet(model, speed, range, price));
				} else if (type.contentEquals("CargoPlane")) {
					jet.add(new CargoPlane(model, speed, range, price));
				} else if (type.contentEquals("JetImpl")) {
					jet.add(new JetImpl(model, speed, range, price));
				} else {
					System.out.println("Unknown type of Jet"); // change to error
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem while reading " + "jets.txt" + ": " + e.getMessage());
		}
		return jet;
	}

	public void displayJets() {
		for (Jet jetPlane : jet) {
			System.out.println(jetPlane);
		}
	}

}
