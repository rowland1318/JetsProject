package com.skilldistillery.jets;

import java.util.Scanner;


public class JetsApplication {
	
	// F I E L D S
	
	private Airfield airfield = new Airfield();
	private Scanner kb = new Scanner(System.in);
	
	// M E T H O D S

	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		jetApp.displayMenu();
		
	}
	
	public void displayMenu() {
	
	boolean menuLoop = true;
	while(menuLoop) {
		airfield.menuPrint();
		int userChoice = kb.nextInt();
		switch(userChoice) {
		case 1:
			airfield.displayJets();
			break;
		case 2:
			airfield.flyAllJets();
			break;
		case 3:
			System.out.println("The Fastest Jet in Your Fleet is " + airfield.viewFastestJet());
			break;
		case 4:
			System.out.println("The Jet With the Longest Range in Your Fleet is: " + airfield.viewLongestRange());
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
			System.out.println("Thank You For Using the Jets Application");
			break;
			
		default:
			System.out.println("Number Not Recognized! Please Select a Menu Item Between 1 and 9: ");
		}
	}
	}
}
