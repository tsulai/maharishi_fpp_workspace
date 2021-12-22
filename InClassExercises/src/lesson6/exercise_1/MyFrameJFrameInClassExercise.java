package lesson6.exercise_1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class MyFrameJFrameInClassExercise extends JFrame{

	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel textPanel;
	private JTextField text1;
	private JTextField text2;
	private JLabel label1;
	private JLabel label2;
	private JButton button;
	
	public MyFrameJFrameInClassExercise() {
		//1.
		initializeWindow();
		
		label1 = new JLabel("Label1");
		label2 = new JLabel("Label2");
		text1 = new JTextField(15);
		text2 = new JTextField(15);
		JButton button = new JButton("Submit");	
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BorderLayout());
		labelPanel.add(label1, BorderLayout.NORTH);
		labelPanel.add(label2, BorderLayout.SOUTH);
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BorderLayout());
		textPanel.add(text1, BorderLayout.NORTH);
		textPanel.add(text2, BorderLayout.SOUTH);
		//textPanel.add(text1, BorderLayout.NORTH);
		//textPanel.add(text2, BorderLayout.SOUTH);
		//main panel ကျမှ add ပြီး borderlayout နဲ့ align ချလို့ရ				
		mainPanel.add(labelPanel, BorderLayout.WEST);
		mainPanel.add(textPanel, BorderLayout.CENTER);
		mainPanel.add(button, BorderLayout.EAST);			
		//2.
		getContentPane().add(mainPanel);
		centerFrameOnDesktop(this);
	}
	
	public void initializeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JFrame Content Pane");	
		centerFrameOnDesktop(this);
		setSize(320,160); 
		setResizable(false);
	}
		
	private void showMessage(String message){
		JOptionPane.showMessageDialog(this,         									          
		          message,
		          "Error", 
		          JOptionPane.ERROR_MESSAGE); //could also be INFORMATION_MESSAGE
	}
	
	public static void centerFrameOnDesktop(Component f) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height;
		int width = toolkit.getScreenSize().width;
		int frameHeight = f.getSize().height;
		int frameWidth = f.getSize().width;
		f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
	}
	
	public static void main(String[] args) {
		//3.
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				MyFrameJFrameInClassExercise mf = new MyFrameJFrameInClassExercise();
				mf.setVisible(true);
			}
		});
	}

}
