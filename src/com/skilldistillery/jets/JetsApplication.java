package com.skilldistillery.jets;

import java.util.Scanner;


public class JetsApplication {
	
	private Airfield airfield = new Airfield();
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		jetApp.displayMenu();
		
	}
	
	public void displayMenu() {
	
	boolean menuLoop = true;
	
	
	while(menuLoop) {
		
		System.out.println("+--------------------------------+");
		System.out.println("|         Jets Main Menu         |");
		System.out.println("|       ------------------       |");
		System.out.println("|        1: List Fleet           |");
		System.out.println("|       2. Fly All Jets          |");
		System.out.println("|      3: View Fastest Jet       |");
		System.out.println("| 4. View Jet with Longest Range |");         
		System.out.println("|     5: Load all Cargo Jets     |");
		System.out.println("|          6. Dogfight!          |");
		System.out.println("|     7. Add a Jet to Fleet      |");
		System.out.println("|   8. Remove a Jet From Fleet   |");
		System.out.println("|           9: Quit              |");
		System.out.println("+--------------------------------+");
		int userChoice = kb.nextInt();
		switch(userChoice) {
		case 1:
			airfield.displayJets();
			break;
		case 2:
			airfield.flyAllJets();
			break;
		case 3:
			System.out.println("The fastest jet is " + airfield.viewFastestJet());
			break;
		case 4:
			System.out.println("The jet with the longest range is: " + airfield.viewLongestRange());
			break;
		case 5:
			airfield.loadCargoPlanes();
			break;
		case 6:
			airfield.dogFight();
			break;
		case 7:
			airfield.addJet();
			break;
		case 8:
			airfield.removeJet();
			break;
		case 9:
			menuLoop = false;
			break;
			
		default:
			System.out.println("Number Not Recognized! Please Select a Menu Item Between 1 and 9: ");
		}
	}
	
	}
	
	


}
