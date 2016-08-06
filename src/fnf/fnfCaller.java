package fnf;

import com.firebase.client.*;

public class fnfCaller {

	public static void main(String[] args) {
		Firebase myFirebaseRef = new Firebase("https://farmboysnfirepower.firebaseio.com/");
		
		myFirebaseRef.child("Units/1/Regiment").setValue("5th Vermont");
	      
		myFirebaseRef.child("Units/1/Regiment").addValueEventListener(new ValueEventListener() {
			  @Override
			  public void onDataChange(DataSnapshot snapshot) {
				  System.out.println(snapshot.getValue());  
			  }

			  @Override public void onCancelled(FirebaseError error) { }

			});
		
		// Get a reference to our posts
		Firebase ref = new Firebase("https://farmboysnfirepower.firebaseio.com/Units/2/Regiment");
	
		// Attach an listener to read the data at our posts reference
	
		ref.addValueEventListener(new ValueEventListener() {
		    @Override
		    public void onDataChange(DataSnapshot snapshot) {
		        System.out.println(snapshot.getValue());
		    }
	
		    @Override
		    public void onCancelled(FirebaseError firebaseError) {
		        System.out.println("The read failed: " + firebaseError.getMessage());
		    }
		});
	}
}
