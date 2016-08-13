package oldCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleMenu {

	public static void main(String[] args)  {
		boolean keepGoing = true;
		do {
			System.out.println("Farmboys and Firepower");
			System.out.println("");
			System.out.println("1) Setup General");
			System.out.println("2) Setup Units");
			System.out.println("3) Setup Game of Gettysburg");
			System.out.println("4) Setup Combat Tables");
			System.out.println("5) Play the Game");
			System.out.println("");
			
			System.out.println("Choose a menu item or 'Q' and Enter.");
			
			String choice = "";
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        try {
	        	choice = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch (choice) {
			case "Q" :
				return;
			case "1" :
				GeneralMenu.menu();
	            break;
			case "2" :
				System.out.println("Menu Item 2");
	            break;
			case "3" :
				GameSetupMenu.menu();
	            break;
			case "4" :
				System.out.println("Menu Item 4");
	            break;
			case "5" :
				GMPhaseMenu.menu();
				System.out.println("Menu Item 5");
	            break;
	        default: 
		   		// garbage data in the database - I will just ignore it
				System.out.println("Not a valid option.");
	            break;
			}
		} while(keepGoing);
	}
}
