package fnf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import fnf_java.AssignGenerals;

public class GameSetupMenu {

	static void menu() {
		boolean keepGoing = true;
		do {
			System.out.println("Game Setup Menu");
			System.out.println("");
			System.out.println("1) Start New Game");
			System.out.println("2) Assign Units a General");
			System.out.println("3) Reasign Units a General");
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
			case "Q":
				keepGoing = false;
				break;
			case "1":
				startNewGame();
				break;
			case "2":
				assignUnits();
				break;
			case "3":
				System.out.println("Menu Item 3");
				break;
			default:
				keepGoing = false;
				break;
			}
		} while (keepGoing);
	}

	private static void startNewGame() {
		System.out.println("Warning, this action will start a new game of Gettysburg");
		System.out.println("The game will be reset to turn 1.");
		System.out.println("The phase will be reset to Move Leaders.");
		System.out.println("The side will be reset to Union.");
		System.out.println("All unit will have there generals unassigned.");
		System.out.println("");
		System.out.println("Are you sure you wish to continue?.");
		System.out.println("This action may not be undone.");
		String answer = "";
		boolean reset = false;
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = br1.readLine();
			answer = answer.toUpperCase();
			if (answer.equals("YES")) {
				reset = true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (reset) {
			Firebase fnfRef = new Firebase("https://farmboysnfirepower.firebaseio.com/");

			fnfRef.child("Game/Name").setValue("Gettysburg");
			fnfRef.child("Game/Phase").setValue("Move Leaders");
			fnfRef.child("Game/Side").setValue("Union");
			fnfRef.child("Game/Turn").setValue(1);
			
			Firebase UnitsRef = fnfRef.child("Units");

			// Attach an listener to read the data at our posts reference

			UnitsRef.addValueEventListener(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot snapshot) {
					for (DataSnapshot unitSnapshot : snapshot.getChildren()) {
						System.out.println("Unit key " + unitSnapshot.getKey());
						java.util.HashMap<String, String> fnfUserData = (java.util.HashMap<String, String>) unitSnapshot.getValue();
						Units unit = new Units(fnfUserData);
					
						fnfRef.child("Units/" + unitSnapshot.getKey() + "/Player").setValue("Unassigned");
						fnfRef.child("Units/" + unitSnapshot.getKey() + "/CurStands").setValue(unit.getMaxStands());
						fnfRef.child("Units/" + unitSnapshot.getKey() + "/Moved").setValue(false);
						fnfRef.child("Units/" + unitSnapshot.getKey() + "/FiredStands").setValue(0);
						fnfRef.child("Units/" + unitSnapshot.getKey() + "/LostedStands").setValue(0);
					}
				}

				@Override
				public void onCancelled(FirebaseError firebaseError) {
				}
			});
		}
	}

	private static void assignUnits() {
		ChooseGeneral chooseGeneralFrame = new ChooseGeneral();
		chooseGeneralFrame.setVisible(true);
		System.out.println("after write completes, press enter to exit");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		User general = chooseGeneralFrame.getGeneral();
		if(general != null) {
			System.out.println("General: " + chooseGeneralFrame.getGeneral().getFirstName());
			System.out.println("General's side is " + general.getSide());
		}
		
		chooseGeneralFrame.setVisible(false);
	}

	static Firebase.CompletionListener setValueCompletionListener = new Firebase.CompletionListener() {
		@Override
		public void onComplete(FirebaseError firebaseError, Firebase firebase) {
			if (firebaseError != null)
				System.out.println("error");
			else
				System.out.println("no error");
		}
	};

}
