package fnf;

import java.io.IOException;

import com.firebase.client.*;
import com.shaded.fasterxml.*;

import fnf_java.Units2;

public class Test5 {

	public static void main(String[] args) {
	    Firebase ref = new Firebase("https://farmboysnfirepower.firebaseio.com/Units");
	
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
}}
