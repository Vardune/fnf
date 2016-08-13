package oldCode;


import java.io.IOException;


import com.firebase.client.*;
import com.shaded.fasterxml.*;

import oldCode.Units2;

public class Test4 {

    static Firebase.CompletionListener setValueCompletionListener = new Firebase.CompletionListener() 
    {
        @Override
        public void onComplete(FirebaseError firebaseError, Firebase firebase) 
        {
            if (firebaseError != null)     System.out.println("error");
            else                        System.out.println("no error"); 
        }
    };
  
    public static void main(String[] args) {
    	Firebase UnitsRef = new Firebase("https://farmboysnfirepower.firebaseio.com/Units2/");

	    System.out.println("after write completes, press enter to exit");
	    try {
	        System.in.read();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
//	    Firebase UnitsRef = myFirebaseRef.child("Units2");
	    		
	    // Attach an listener to read the data at our posts reference
	
	    UnitsRef.addListenerForSingleValueEvent(new ValueEventListener() {
	        @Override
	        public void onDataChange(DataSnapshot snapshot) {
	            System.out.println("There are " + snapshot.getChildrenCount() + " units");
	            System.out.println("boo " + snapshot.toString());
	            
	            
	            for (DataSnapshot unitSnapshot : snapshot.getChildren()) {
	              Units2 unit = unitSnapshot.getValue(Units2.class);
	              System.out.println(unit.getDivision() + " - " + unit.getCorps());
	            }
	        }
	
	        @Override
	        public void onCancelled(FirebaseError firebaseError) {
	            System.out.println("The read failed: " + firebaseError.getMessage());
	        }
	    });
	    
	    System.out.println("exiting");
	
/*
	    Firebase ref = new Firebase("https://stackoverflow.firebaseio.com/32108969/users");
		
		ref.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot usersSnapshot) {
				for (DataSnapshot userSnapshot : usersSnapshot.getChildren()) {
					User user = userSnapshot.getValue(User.class);
					System.out.println(user.toString());
				}
			}
		
			@Override
			public void onCancelled(FirebaseError firebaseError) { }
		});
		
		Firebase ref = new Firebase("https://stackoverflow.firebaseio.com/32108969/users");

ref.addListenerForSingleValueEvent(new ValueEventListener() {
  @Override
  public void onDataChange(DataSnapshot usersSnapshot) {
    for (DataSnapshot userSnapshot : usersSnapshot.getChildren()) {
      User user = userSnapshot.getValue(User.class);
      System.out.println(user.toString());
    }
  }

  @Override
  public void onCancelled(FirebaseError firebaseError) { }
});

		*/
    }
}
