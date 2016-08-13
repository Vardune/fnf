package oldCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import fnf.User;

public class GeneralMenu {

	static void menu() {
		boolean keepGoing = true;
		do {
			System.out.println("General Menu");
			System.out.println("");
			System.out.println("1) Enter New General");
			System.out.println("2) Edit Existing General");
			System.out.println("3) Delete Existing General");
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
				keepGoing = false;
				break;
			case "1" :
				newGeneral();
	            break;
			case "2" :
				System.out.println("Menu Item 2");
	            break;
			case "3" :
				System.out.println("Menu Item 3");
	            break;
	        default: 
	        	keepGoing = false;
				break;
			}
		} while(keepGoing);
	}

	private static void newGeneral() {
		User general = new User();
		System.out.println("Enter First Name");
		String firstName = "";
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        try {
        	firstName = br1.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		general.setFirstName(firstName);
		System.out.println("First Name: " + general.getFirstName());
		
		System.out.println("Enter Last Name");
		String lastName = "";
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        try {
        	lastName = br2.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		general.setLastName(lastName);
		System.out.println("Last Name: " + general.getLastName());
		
		System.out.println("Enter Email");
		String email = "";
        BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
        try {
        	email = br3.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		general.setEmail(email);
		System.out.println("Email: " + general.getEmail());
		
		System.out.println("Enter Phone");
		String phone = "";
        BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
        try {
        	phone = br4.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		general.setPhone(phone);
		System.out.println("Phone: " + general.getPhone());
		
		System.out.println("Enter Side");
		String side = "";
        BufferedReader br6 = new BufferedReader(new InputStreamReader(System.in));
        try {
        	side = br6.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		general.setSide(side);
		System.out.println("Side: " + general.getSide());

		general.setType("Player");

		System.out.println("******************************");
		System.out.println("First Name: " + general.getFirstName());
		System.out.println("Last Name: " + general.getLastName());
		System.out.println("Email: " + general.getEmail());
		System.out.println("Phone: " + general.getPhone());
		System.out.println("Side: " + general.getSide());
		System.out.println("Type: " + general.getType());
		
		System.out.println("Save this general (Y/N)");
		boolean save = false;
        BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));
        try {
        	String answer = br5.readLine();
        	if (answer.toUpperCase().equals("Y")) save = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if (save) {
	        Firebase fnfRef = new Firebase("https://farmboysnfirepower.firebaseio.com/");
	    	Firebase userRef = fnfRef.child("Users");
	
	    	Map<String, String> gen = new HashMap<String, String>();
	    	gen.put("FirstName", general.getFirstName());
	    	gen.put("LastName", general.getLastName());
	    	gen.put("Email", general.getEmail());
	    	gen.put("Phone", general.getPhone());
	    	gen.put("Side", general.getSide());
	    	gen.put("Type", "Player");
	    	userRef.push().setValue(gen);
        }
	}
}
