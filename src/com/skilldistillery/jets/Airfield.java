package com.skilldistillery.jets;

import java.io.*;
import java.util.*;

public class Airfield {

	// F I E L D S

	private List<Jet> jet = new ArrayList<>();
	private Scanner kb = new Scanner(System.in);

	// M E T H O D S

	public Airfield() {
		readAndPopulateFromFile();
	}

	public void menuPrint() {
		System.out.println("+---------------------------------+");
		System.out.println("|          Jets Main Menu         |");
		System.out.println("|        ------------------       |");
		System.out.println("|         1: List Fleet           |");
		System.out.println("|        2. Fly All Jets          |");
		System.out.println("|       3: View Fastest Jet       |");
		System.out.println("|  4. View Jet with Longest Range |");         
		System.out.println("|      5: Load All Cargo Jets     |");
		System.out.println("|           6. Dogfight!          |");
		System.out.println("|    7. Add a Jet to Your Fleet   |");
		System.out.println("| 8. Remove a Jet From Your Fleet |");
		System.out.println("|            9: Quit              |");
		System.out.println("+---------------------------------+");
	}
	
	public void displayJets() { //CASE 1
		for (Jet jetPlane : jet) {
			System.out.println(jetPlane);
		}
	}
	
	public void flyAllJets() { //CASE 2
		for (Jet jetFly : jet) {
			jetFly.fly();
		}
	}

	public String viewFastestJet() { //CASE 3
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

	public String viewLongestRange() { //CASE 4
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

	public void loadCargoPlanes() { //CASE 5
		for (Jet currentJet : jet) {
			if (currentJet instanceof CargoPlane) {
				CargoPlane planeWithCargo = ((CargoPlane) currentJet);
				System.out.println("Looking at: " + planeWithCargo.toString());
				System.out.println(planeWithCargo.loadCargo());
			}
		}
	}

	public void dogFight() { //CASE 6
		for (Jet currentJet : jet) {
			if (currentJet instanceof FighterJet) {
				FighterJet planeCanFight = ((FighterJet) currentJet);
				System.out.println("Looking at: " + planeCanFight.toString());
				System.out.println(planeCanFight.fight());
			}

		}
	}

	public void addJet() { //CASE 7
		System.out.println("Please Type the Number Associated With the Type of Jet That You Would Like to Add to Your Fleet: ");
		System.out.println("1. Fighter Jet");
		System.out.println("2. Cargo Plane");
		System.out.println("3. Passenger Jet");
		

		int planeType = kb.nextInt();		
		kb.nextLine();
		System.out.print("Enter the Model of the Jet: ");
		String model = kb.nextLine();
		System.out.print("Enter the Top Speed of the Jet: ");
		double speed = kb.nextDouble();
		System.out.print("Enter the Maximum Range of the Jet: ");
		int range = kb.nextInt();
		System.out.print("Enter the Price of the Jet: ");
		long price = kb.nextLong();
		kb.nextLine();

			if (planeType == 1) {
				FighterJet fighterJet = new FighterJet(model, speed, range, price);
				jet.add(fighterJet);
				System.out.println("You have added a " + fighterJet.getModel() + " " + fighterJet.getClass().getSimpleName() + " to your Fleet.");
			} else if (planeType == 2) {
				CargoPlane cargoPlane = new CargoPlane(model, speed, range, price);
				jet.add(cargoPlane);
				System.out.println("You have added a " + cargoPlane.getModel() + " " +cargoPlane.getClass().getSimpleName() + " to your Fleet.");
			} else if (planeType == 3) {
				PassengerJet jetImpl = new PassengerJet(model, speed, range, price);
				jet.add(jetImpl);
				System.out.println("You have added a " + jetImpl.getModel() + " " + jetImpl.getClass().getSimpleName() + " to your Fleet.");
			} else {
				System.out.println("Number Was Not Recognized for Jet Selection! Jet Was Not Added!");
			}
		}
		
//		
//		}
	

	public void removeJet() { //CASE 8
		System.out.println("Please Select the Number Associated With the Jet That You Would Like to Remove: ");
		for (int index = 0; index < jet.size(); index++) {
			System.out.println((index + 1) + ". " + jet.get(index));
		}

		int userInput = kb.nextInt();
		Jet removedJet = jet.remove(userInput - 1);
		System.out.println(removedJet.getModel() + " was removed");
	}

	public List<Jet> readAndPopulateFromFile() { // reading file jets.txt to populate array list
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
				} else if (type.contentEquals("PassengerJet")) {
					jet.add(new PassengerJet(model, speed, range, price));
				} else {
					System.out.println("Unknown Type of Jet"); 
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid Filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Problem While Reading " + "jets.txt" + ": " + e.getMessage());
		}
		return jet;
	}
}
