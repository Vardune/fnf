package fnf;

// Imports
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;

import javax.swing.*;
import javax.swing.event.*;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class ChooseGeneral
	extends 	JFrame
	implements	ActionListener,
				ListSelectionListener
	{
	// Instance attributes used in this example
	private	JPanel		topPanel;
	private	JList		listbox;
	private	Vector		listData;
	private	JButton		addButton;
	private	JButton		doneButton;
	private	JTextField	dataField;
	private	JScrollPane scrollPane;
	private User		general;
	private ArrayList	generals;
	
	// Constructor of main frame
	public ChooseGeneral()
	{
		// Set the frame characteristics
		setTitle( "Choose General ");
		setSize( 300, 300 );
		setBackground( Color.gray );
	
		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );
	
		// Create the data model for this example
		listData = new Vector();
	
		// Create a new listbox control
		listbox = new JList( listData );
		listbox.addListSelectionListener( this );
	
		// Add the listbox to a scrolling pane
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add( listbox );
		topPanel.add( scrollPane, BorderLayout.CENTER );
	
		CreateDataEntryPanel();
		loadListbox();
	}
	
	
	public void CreateDataEntryPanel()
	{
		// Create a panel to hold all other components
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout( new BorderLayout() );
		topPanel.add( dataPanel, BorderLayout.SOUTH );
	
		// Create some function buttons
		addButton = new JButton( "Chose one general ");
		dataPanel.add( addButton, BorderLayout.CENTER );
		addButton.addActionListener( this );

		doneButton = new JButton( "Done");
		dataPanel.add( doneButton, BorderLayout.EAST );
		doneButton.addActionListener( this );
	}
	
	// Handler for list selection changes
	public void valueChanged( ListSelectionEvent event )
	{
		// See if this is a listbox selection and the
		// event stream has settled
		if( event.getSource() == listbox && !event.getValueIsAdjusting() ) {
			// Get the current selection and place it in the
			// edit field
			String stringValue = (String)listbox.getSelectedValue();
//			if( stringValue != null ) dataField.setText( stringValue );
		}
	}
	
	// Handler for button presses
	public void actionPerformed( ActionEvent event )
	{
		if( event.getSource() == addButton )
		{
			int ii = listbox.getSelectedIndex();
			if(ii != -1) {
				general = (User) generals.get(ii);
				AssignGenerals assignGeneralFrame = new AssignGenerals(general);
				assignGeneralFrame.setVisible( true );
			}
		}
		if (event.getSource() == doneButton) {
			this.setVisible(false);
		}
	
	}
	
	public void loadListbox() {
		Firebase myFirebaseRef = new Firebase("https://farmboysnfirepower.firebaseio.com/");
		
		Firebase UnitsRef = myFirebaseRef.child("Users");
	        
	    // Attach an listener to read the data at our posts reference
	    
		UnitsRef.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				ArrayList users = new ArrayList();
				for (DataSnapshot userSnapshot: snapshot.getChildren()) {
					java.util.HashMap<String, String> fnfUserData = (java.util.HashMap<String, String>) userSnapshot.getValue();
                
					User user = new User(fnfUserData);
					user.setKey(userSnapshot.getKey());
					listData.addElement( user.getFirstName() + " " + user.getLastName());
					users.add(user);
				}
				listbox.setListData( listData );
				generals = users;
			}

			@Override
			public void onCancelled(FirebaseError firebaseError) {
			}
		});
	    
    }

	static Firebase.CompletionListener setValueCompletionListener = new Firebase.CompletionListener() {
	    @Override
	    public void onComplete(FirebaseError firebaseError, Firebase firebase) 
	    {
	        if (firebaseError != null)     System.out.println("error");
	        else                        System.out.println("no error"); 
	    }
	};
	
	public User getGeneral() {
		return general;
	}
}
