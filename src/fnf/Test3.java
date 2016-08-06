package fnf;

import java.io.IOException;

import com.firebase.client.*;
import com.shaded.fasterxml.*;

import fnf_java.User;

public class Test3 {

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
    Firebase myFirebaseRef = new Firebase("https://farmboysnfirepower.firebaseio.com/");

    myFirebaseRef.child("Users/1").addValueEventListener(new ValueEventListener() {
         @Override
         public void onDataChange(DataSnapshot snapshot) {
             System.out.println("sanity " + snapshot.getValue());  
         }

         @Override public void onCancelled(FirebaseError error) {
             System.out.println("canceled");
         }
    });
    
	Firebase alanRef = myFirebaseRef.child("Users").child("1");
	User alan = new User("Alan", "Dyer", "360-886-2519", "alangdyer1@yahoo.com", "Confederate");
	alanRef.setValue(alan);
	
	Firebase fredRef = myFirebaseRef.child("Users").child("2");
	User fred = new User("Jason", "Trout", "858-449-5512", "damadboat@gmail.com", "Union");
	fredRef.setValue(fred);
	
    System.out.println("after write completes, press enter to exit");
    try {
        System.in.read();
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    myFirebaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {
            System.out.println("doing this once");
            String regiment = (String) snapshot.child("Units/1/Regiment").getValue();
            System.out.println("Regiment " + regiment + " has been retrieved");
        }
        @Override
        public void onCancelled(FirebaseError firebaseError) {
        }
    });
    
    System.out.println("exiting");
    }
};
    


