package fnf;

import java.io.IOException;

import com.firebase.client.*;
import com.shaded.fasterxml.*;

import fnf_java.Units2;

public class Test6 {

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

       System.out.println("after write completes, press enter to exit");
       try {
           System.in.read();
       } catch (IOException e) {
           e.printStackTrace();
       }
       
       Firebase UnitsRef = myFirebaseRef.child("Users");
               
       // Attach an listener to read the data at our posts reference
    
       UnitsRef.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot snapshot) {
               System.out.println("There are " + snapshot.getChildrenCount() + " users");
               System.out.println("boo " + snapshot.toString());
               
               for (DataSnapshot unitSnapshot: snapshot.getChildren()) 
               {
                   java.util.HashMap<String, String> fnfUserData = (java.util.HashMap<String, String>) unitSnapshot.getValue();
                   System.out.println("fnfUserData.getClass().toString() = " + fnfUserData.getClass().toString());
                   System.out.println(fnfUserData.toString()); 
                   
                   User unit = new User(fnfUserData);
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
*/
    }
}