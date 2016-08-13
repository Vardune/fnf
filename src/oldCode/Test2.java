package oldCode;

import java.io.IOException;

import com.firebase.client.*;

public class Test2 {

	static Firebase.CompletionListener setValueCompletionListener = new Firebase.CompletionListener() {
		@Override
		public void onComplete(FirebaseError firebaseError, Firebase firebase) {
			if (firebaseError != null)
				System.out.println("error");
			else
				System.out.println("no error");
		}
	};

	public static void main(String[] args) {
		Firebase myFirebaseRef = new Firebase("https://farmboysnfirepower.firebaseio.com/");

		myFirebaseRef.child("Game/bullshit").addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				System.out.println("sanity " + snapshot.getValue());
			}

			@Override
			public void onCancelled(FirebaseError error) {
				System.out.println("canceled");
			}
		});
		myFirebaseRef.child("Game/bullshit").setValue("horse flies", setValueCompletionListener);
		System.out.println("after write completes, press enter to exit");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("exiting");
	}
}
