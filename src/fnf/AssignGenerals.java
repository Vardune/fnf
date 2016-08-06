package fnf;

// Imports
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class AssignGenerals extends JFrame implements ActionListener, ListSelectionListener {
	// Instance attributes used in this example
	private JPanel topPanel;
	private JList listbox;
	private Vector listData;
	private JButton assignButton;
	private JButton doneButton;
	private JButton scanButton;
	private JTextField dataField;
	private JScrollPane scrollPane;

	private User general;
	private Units unit;
	private ArrayList unitsArray;

	// Constructor of main frame
	public AssignGenerals(User general) {
		// Set the frame characteristics
		setTitle("Assign General " + general.getFirstName() + " " + general.getLastName());
		setSize(300, 300);
		setBackground(Color.gray);

		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		// Create the data model for this example
		listData = new Vector();

		// Create a new listbox control
		listbox = new JList(listData);
		listbox.addListSelectionListener(this);

		// Add the listbox to a scrolling pane
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(listbox);
		topPanel.add(scrollPane, BorderLayout.CENTER);

		CreateDataEntryPanel(general);
		loadListbox(general);
	}

	public void CreateDataEntryPanel(User general) {
		// Create a panel to hold all other components
		JPanel dataPanelSouth = new JPanel();
		dataPanelSouth.setLayout(new BorderLayout());
		JPanel dataPanelNorth = new JPanel();
		dataPanelNorth.setLayout(new BorderLayout());

		topPanel.add(dataPanelSouth, BorderLayout.SOUTH);
		// Create some function buttons
		assignButton = new JButton("Assign highlighed units to " + general.getFirstName());
		dataPanelSouth.add(assignButton, BorderLayout.CENTER);
		assignButton.addActionListener(this);

		doneButton = new JButton("Done");
		dataPanelSouth.add(doneButton, BorderLayout.EAST);
		doneButton.addActionListener(this);

		topPanel.add(dataPanelNorth, BorderLayout.NORTH);
		scanButton = new JButton("Scan units to select");
		dataPanelNorth.add(scanButton, BorderLayout.CENTER);
		scanButton.addActionListener(this);

		this.general = general;
	}

	// Handler for list selection changes
	public void valueChanged(ListSelectionEvent event) {
		// See if this is a listbox selection and the
		// event stream has settled
		if (event.getSource() == listbox && !event.getValueIsAdjusting()) {
			// Get the current selection and place it in the
			// edit field
			String stringValue = (String) listbox.getSelectedValue();
		}
	}

	// Handler for button presses
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == assignButton) {
			for (int index : listbox.getSelectedIndices()) {
				unit = (Units) unitsArray.get(index);
				Firebase fnfRef = new Firebase("https://farmboysnfirepower.firebaseio.com/");
				fnfRef.child("Units/" + unit.getKey() + "/Player").addValueEventListener(new ValueEventListener() {

					@Override
					public void onDataChange(DataSnapshot snapshot) {
						System.out.println("sanity " + snapshot.getValue());
						
					}

					@Override
					public void onCancelled(FirebaseError error) {
						System.out.println("canceled");
					}
				});
				fnfRef.child("Units/" + unit.getKey() + "/Player").setValue(general.getKey(), setValueCompletionListener);
			}
		}
		if (event.getSource() == doneButton) {
			this.dispose();
		}

	}

	public void loadListbox(User general) {
		this.general = general;
		Firebase myFirebaseRef = new Firebase("https://farmboysnfirepower.firebaseio.com/");

		Firebase UnitsRef = myFirebaseRef.child("Units");

		// Attach an listener to read the data at our posts reference

		UnitsRef.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				String side = general.getSide();
				ArrayList unitsA = new ArrayList();
				for (DataSnapshot unitSnapshot : snapshot.getChildren()) {
					java.util.HashMap<String, String> fnfUserData = (java.util.HashMap<String, String>) unitSnapshot.getValue();
					Units unit = new Units(fnfUserData);
					unit.setKey(unitSnapshot.getKey());
					if (side.equals(unit.getSide())) {
						if (unit.getPlayer().equals("Unassigned")) {
							listData.addElement(unit.getRegiment());
							unitsA.add(unit);
						}
					}
				}
				listbox.setListData(listData);
				unitsArray = unitsA;
			}

			@Override
			public void onCancelled(FirebaseError firebaseError) {
			}
		});

	}

	static Firebase.CompletionListener setValueCompletionListener = new Firebase.CompletionListener() {
		@Override
		public void onComplete(FirebaseError firebaseError, Firebase firebase) {
			if (firebaseError != null)
				System.out.println("error");
		}
	};
}
