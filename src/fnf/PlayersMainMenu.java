package fnf;

// Imports
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.swing.*;
import javax.swing.event.*;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class PlayersMainMenu extends JFrame implements ActionListener, ListSelectionListener {

	// Instance attributes used in this example
	private JPanel topPanel;
	private JButton selectButton;
	private JButton doneButton;
	private JTextField dataField;
	private JScrollPane scrollPane;
	private User general;

	public void main(String[] args)  {
		setupFirstScreen();
	}
	
	// Constructor of main frame
	public void setupFirstScreen() {
		// Set the frame characteristics
		setTitle("Welcome to Farmboy and Firepower");
		setSize(300, 300);
		setBackground(Color.gray);

		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		getContentPane().add(topPanel);

		// Add the listbox to a scrolling pane
		scrollPane = new JScrollPane();
		topPanel.add(scrollPane, BorderLayout.CENTER);

		CreateDataEntryPanel();
	}

	public void CreateDataEntryPanel() {
		// Create a panel to hold all other components
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new BorderLayout());
		topPanel.add(dataPanel, BorderLayout.SOUTH);

		// Create some function buttons
		selectButton = new JButton("Chose one general ");
		dataPanel.add(selectButton, BorderLayout.CENTER);
		selectButton.addActionListener(this);

		doneButton = new JButton("Done");
		dataPanel.add(doneButton, BorderLayout.EAST);
		doneButton.addActionListener(this);
	}

	// Handler for button presses
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == selectButton) {
			ChooseGeneral chooseGeneralFrame = new ChooseGeneral();
			chooseGeneralFrame.setVisible(true);
			this.general = chooseGeneralFrame.getGeneral();
			chooseGeneralFrame.dispose();
		}
		if (event.getSource() == doneButton) {
			this.dispose();
		}

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

	public User getGeneral() {
		return general;
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
		if (general != null) {
			System.out.println("General: " + chooseGeneralFrame.getGeneral().getFirstName());
			System.out.println("General's side is " + general.getSide());
		}

		chooseGeneralFrame.setVisible(false);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
