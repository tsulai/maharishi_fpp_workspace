package javadb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class AddressForm extends JFrame{
	public static final int LABEL_SIZE_SMALL = 7;
	public static final int LABEL_SIZE_BIG = 11;
	public static final String TITLE_TEXT = "Address Form";
	public static final String LABLE_TEXT_ID = "ID";
	public static final String LABLE_TEXT_FIRST_NAME = "First Name";
	public static final String LABLE_TEXT_LAST_NAME = "Last Name";
	public static final String LABLE_TEXT_SSN = "SSN";
	public static final String LABEL_TEXT_STREET = "Street";
	public static final String LABEL_TEXT_CITY = "City";
	public static final String LABEL_TEXT_STATE = "State";
	public static final String LABEL_TEXT_ZIP = "Zip";
	public static final String SUBMIT_BUTTON_TEXT = "Submit";
	public static final String SEARCH_BUTTON_TEXT = "Search";
	public static final String SAVE_BUTTON_TEXT = "Save";
	public static final String CLEAR_BUTTON_TEXT = "Clear";
	public static final String DEFAULT_MESSAGE_TEXT = "";
	public static final String MESSAGE_EMPTY_ID_TEXT = "Please select ID";
	public static final String MESSAGE_RESULTS_FOUND = "Records Found";
	public static final String MESSAGE_NO_RESULTS_FOUND = "No Records Found";
	public static final String MESSAGE_ADDRESS_UPDATED = "Database has been updated";
	public static final String MESSAGE_ALL_FIELDS_MUST_BE_EMPTY = "To performe a save, all field must not be empty";
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel midBottomPanel;
	private JPanel bottomPanel;
	private JTextField textId;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textSsn;
	private JTextField textStreet;
	private JTextField textCity;
	private JTextField textState;
	private JTextField textZip;
	private JTextField labelMessage;
	private JLabel labelId;
	private JLabel labelFirstName;
	private JLabel labelLastName;
	private JLabel labelSsn;
	private JLabel labelStreet;
	private JLabel labelCity;
	private JLabel labelState;
	private JLabel labelZip;
	private JButton button;
	private JButton buttonSearch;
	private JButton buttonSave;
	private JButton buttonClear;
	public AddressForm() {
		initializeWindow();
		JPanel mainPanel = new JPanel();
		defineTopPanel();
		defineMiddlePanel();
		
		defineMidBottomPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(middlePanel, BorderLayout.CENTER);
		mainPanel.add(midBottomPanel, BorderLayout.SOUTH);
		//mainPanel.add(bottomPanel, BorderLayout.SOUTH);

		//defineBottomPanel();
		getContentPane().add(mainPanel);
	}

	private void defineTopPanel() {
		topPanel = new JPanel();
		JPanel textPanelId = defineAddressId();
		JPanel textPanelName = defineAddressFirstName();
		JPanel textPanelLastName = defineAddressLastName();
		JPanel textPanelSsn = defineAddressSsn();

		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(textPanelId);
		topPanel.add(textPanelName);
		topPanel.add(textPanelLastName);
		topPanel.add(textPanelSsn);
	}

	private void defineMiddlePanel() {
		middlePanel = new JPanel();
		JPanel textPanelState = defineAddressState();
		JPanel textPanelZip = defineAddressZip();
		JPanel textPanelStreet = defineAddressStreet();
		JPanel textPanelCity = defineAddressCity();
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		middlePanel.add(textPanelStreet);
		middlePanel.add(textPanelCity);
		middlePanel.add(textPanelState);
		middlePanel.add(textPanelZip);
	}

	private void defineMidBottomPanel() {
		defineBottomPanel();
		midBottomPanel = new JPanel();
		labelMessage = new JTextField(100);
		labelMessage.setEditable(false);
		labelMessage.setText(DEFAULT_MESSAGE_TEXT);
		labelMessage.setForeground(Color.red);
		
		midBottomPanel.setLayout(new BorderLayout());
		
		midBottomPanel.add(labelMessage,BorderLayout.NORTH);
		midBottomPanel.add(bottomPanel,BorderLayout.CENTER);
		//bottomPanel.add(buttonSave);
		//bottomPanel.add(buttonClear);
		
	}
	
	private void defineBottomPanel() {
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		button = new JButton(SUBMIT_BUTTON_TEXT);
		buttonSearch = new JButton(SEARCH_BUTTON_TEXT);
		buttonSearch.addActionListener(evnt->searchAddress());
		buttonSave = new JButton(SAVE_BUTTON_TEXT);
		buttonSave.addActionListener(envt->updateAddress());
		buttonClear = new JButton(CLEAR_BUTTON_TEXT);
		buttonClear.addActionListener(envt->clearAddressFields());
		button.addActionListener(new submitButtonListener());
		bottomPanel.add(buttonSearch);
		bottomPanel.add(buttonSave);
		bottomPanel.add(buttonClear);
		
	}

	private JPanel defineAddressUnit() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		

		textFirstName = new JTextField(LABEL_SIZE_BIG);
		labelFirstName = new JLabel(LABLE_TEXT_FIRST_NAME);
		labelFirstName.setFont(makeSmallFont(labelFirstName.getFont()));
		topText.add(labelFirstName);
		bottomText.add(textFirstName);

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(topText,BorderLayout.NORTH);
		textPanel.add(bottomText,BorderLayout.CENTER);
		return textPanel;
	}

	private JPanel defineAddressFirstName() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		

		textFirstName = new JTextField(LABEL_SIZE_BIG);
		labelFirstName = new JLabel(LABLE_TEXT_FIRST_NAME);
		labelFirstName.setFont(makeSmallFont(labelFirstName.getFont()));
		topText.add(labelFirstName);
		bottomText.add(textFirstName);
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(topText,BorderLayout.NORTH);
		textPanel.add(bottomText,BorderLayout.CENTER);
		return textPanel;
	}
	
	private JPanel defineAddressLastName() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		

		textLastName = new JTextField(LABEL_SIZE_BIG);
		labelLastName = new JLabel(LABLE_TEXT_LAST_NAME);
		labelLastName.setFont(makeSmallFont(labelLastName.getFont()));
		topText.add(labelLastName);
		bottomText.add(textLastName);
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(topText,BorderLayout.NORTH);
		textPanel.add(bottomText,BorderLayout.CENTER);
		return textPanel;
	}
	
	private JPanel defineAddressId() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		

		textId = new JTextField(LABEL_SIZE_SMALL);
		labelId = new JLabel(LABLE_TEXT_ID);
		labelId.setFont(makeSmallFont(labelId.getFont()));
		topText.add(labelId);
		bottomText.add(textId);
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(topText,BorderLayout.NORTH);
		textPanel.add(bottomText,BorderLayout.CENTER);
		return textPanel;
	}
	
	private JPanel defineAddressSsn() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		

		textSsn = new JTextField(LABEL_SIZE_BIG);
		labelSsn = new JLabel(LABLE_TEXT_SSN);
		labelSsn.setFont(makeSmallFont(labelSsn.getFont()));
		topText.add(labelSsn);
		bottomText.add(textSsn);
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(topText,BorderLayout.NORTH);
		textPanel.add(bottomText,BorderLayout.CENTER);
		return textPanel;
	}

	private JPanel defineAddressStreet() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		

		textStreet = new JTextField(LABEL_SIZE_BIG);
		labelStreet = new JLabel(LABEL_TEXT_STREET);
		labelStreet.setFont(makeSmallFont(labelStreet.getFont()));
		topText.add(labelStreet);
		bottomText.add(textStreet);

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(topText,BorderLayout.NORTH);
		textPanel.add(bottomText,BorderLayout.CENTER);
		return textPanel;
	}

	private JPanel defineAddressCity() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		

		textCity = new JTextField(LABEL_SIZE_BIG);
		labelCity = new JLabel(LABEL_TEXT_CITY);
		labelCity.setFont(makeSmallFont(labelCity.getFont()));
		topText.add(labelCity);
		bottomText.add(textCity);

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(topText,BorderLayout.NORTH);
		textPanel.add(bottomText,BorderLayout.CENTER);
		return textPanel;
	}

	private JPanel defineAddressState() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		

		textState = new JTextField(LABEL_SIZE_BIG);
		labelState = new JLabel(LABEL_TEXT_STATE);
		labelState.setFont(makeSmallFont(labelState.getFont()));
		topText.add(labelState);
		bottomText.add(textState);

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(topText,BorderLayout.NORTH);
		textPanel.add(bottomText,BorderLayout.CENTER);
		return textPanel;
	}

	private JPanel defineAddressZip() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		

		textZip = new JTextField(LABEL_SIZE_BIG);
		labelZip = new JLabel(LABEL_TEXT_ZIP);
		labelZip.setFont(makeSmallFont(labelZip.getFont()));
		topText.add(labelZip);
		bottomText.add(textZip);

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(topText,BorderLayout.NORTH);
		textPanel.add(bottomText,BorderLayout.CENTER);
		return textPanel;
	}

	private void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(TITLE_TEXT);
		setSize(600,200);
		handleWindowClosing();
		centerFrameOnDesktop(this);
		setResizable(false);
	}
	public static Font makeSmallFont(Font f) {
		return new Font(f.getName(), f.getStyle(), (f.getSize()-2));
	}

	private void handleWindowClosing() {
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent w) {
				dispose();
				//other clean-up
				System.exit(0);
			}
		});
	}
	public static void centerFrameOnDesktop(Component f) {
		final int SHIFT_AMOUNT = 0;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width  = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth  = f.getSize().width;
		f.setLocation(((width-frameWidth)/2)-SHIFT_AMOUNT, (height-frameHeight)/3);    
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				AddressForm mf = new AddressForm();
				mf.setVisible(true);
			}
		});
	}
	void showMessage(String message){
		JOptionPane.showMessageDialog(this,         

				message,
				"Error", 
				JOptionPane.ERROR_MESSAGE); //could also be INFORMATION_MESSAGE
	}

	class submitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String textNameVal = textFirstName.getText();
			String textStreetVal = textStreet.getText();
			String textCityVal = textCity.getText();
			String textStateVal = textState.getText();
			String textZipVal = textZip.getText();
			System.out.println(textNameVal);
			System.out.println(textStreetVal);
			System.out.println(textCityVal +" , " + textStateVal + " "+ textZipVal);
		}
	}
	
	public void searchAddress() {
		String textIdVal = textId.getText();
		if(textIdVal.equals("")) {
			labelMessage.setText(MESSAGE_EMPTY_ID_TEXT);
			return;
		}
		try {
			Address address = SearchAndUpdateDatabase.searchAddress(textIdVal);
			if(address == null) {
				labelMessage.setText(MESSAGE_NO_RESULTS_FOUND);
			}
			else {
				textFirstName.setText(address.getPerson().getFirstName());
				textLastName.setText(address.getPerson().getLastName());
				textSsn.setText(address.getPerson().getSsn());
				textStreet.setText(address.getStreet());
				textCity.setText(address.getCity());
				textState.setText(address.getState());
				textZip.setText(address.getZip());
				labelMessage.setText(MESSAGE_RESULTS_FOUND);
			}
		}
		catch(SQLException e) {
			System.out.println("Error while searching for ID" + textIdVal );
		}
	}
	
	public void updateAddress() { 
		String textIdVal =  textId.getText();
		String textFirstNameVal=textFirstName.getText();
		String textLastNameVal = textLastName.getText();
		String textSsnVal =	textSsn.getText();
		String textStreetVal =textStreet.getText();
		String textCityVal =textCity.getText();
		String textStateVal = textState.getText();
		String textZipVal =	textZip.getText();
		if(textFirstNameVal.equals("") || textLastNameVal.equals("") || textSsnVal.equals("") || textStreetVal.equals("") || textCityVal.equals("") || textStateVal.equals("") || textZipVal.equals("") ) {
			labelMessage.setText(MESSAGE_ALL_FIELDS_MUST_BE_EMPTY);
			return;
		}
		try {
			SearchAndUpdateDatabase.updateAddress(
					textFirstName.getText(),
					textLastName.getText(),
					textSsn.getText(),
					textStreet.getText(),
					textCity.getText(),
					textState.getText(),
					textZip.getText());
			labelMessage.setText(MESSAGE_ADDRESS_UPDATED);
		}
		catch(SQLException e) {
			System.out.print("Error while updating data for " + textId.getText() );
		}
		
	}
	
	public void clearAddressFields() {
		textId.setText("");
		textFirstName.setText("");
		textLastName.setText("");
		textSsn.setText("");
		textStreet.setText("");
		textCity.setText("");
		textState.setText("");
		textZip.setText("");
		labelMessage.setText(DEFAULT_MESSAGE_TEXT);
	}

	private static final long serialVersionUID = 3618976789175941431L;



}


