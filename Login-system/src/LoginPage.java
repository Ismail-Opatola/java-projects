import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton loginBtn = new JButton("Login");
	JButton resetBtn = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("UserID: ");
	JLabel userPasswordLabel = new JLabel("Password: ");
	JLabel messageLabel = new JLabel();
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();

	LoginPage(HashMap<String, String> loginInfoOriginal) {
		loginInfo = loginInfoOriginal; // make a copy

		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		
		userIDField.setBounds(125, 100, 200,25);
		userPasswordField.setBounds(125, 150, 200,25);
		
		loginBtn.setBounds(125, 200, 100, 25);
		loginBtn.setFocusable(false);
		loginBtn.addActionListener(this);
		resetBtn.setBounds(225, 200, 100, 25);
		resetBtn.setFocusable(false);
		resetBtn.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginBtn);
		frame.add(resetBtn);
		frame.add(messageLabel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == resetBtn) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource() == loginBtn) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(userID.isBlank() || password.isBlank()) {
				JOptionPane
				.showOptionDialog(
					null, 
					"Enter Username and Password",
					"Feedback", 
					JOptionPane.CANCEL_OPTION, 
					JOptionPane.WARNING_MESSAGE, 
					null,
					null,
					null
				);
				return;
			}
			
			// verify credentials
			if(loginInfo.containsKey(userID)) {
				if(loginInfo.get(userID).equals(password)) {
//					messageLabel.setForeground(Color.green);
//					messageLabel.setText("Login successful");
					frame.dispose(); // close login window
					WelcomePage welcomePage = new WelcomePage(userID); // open new window and display welcome message with userID
					
					JOptionPane
					.showOptionDialog(
						null, 
						"Login successful",
						"Feedback", 
						JOptionPane.OK_OPTION, 
						JOptionPane.PLAIN_MESSAGE, 
						null,
						null,
						null
					);
				} else {
//					messageLabel.setForeground(Color.red);
//					messageLabel.setText("Wrong password");
					
					JOptionPane
					.showOptionDialog(
						null, 
						"Wrong password",
						"Feedback", 
						JOptionPane.CANCEL_OPTION, 
						JOptionPane.WARNING_MESSAGE, 
						null,
						null,
						null
					);
				}
			} else {
//				messageLabel.setForeground(Color.red);
//				messageLabel.setText("username not found");
				
				JOptionPane
				.showOptionDialog(
					null, 
					"username not found",
					"Feedback", 
					JOptionPane.CANCEL_OPTION, 
					JOptionPane.ERROR_MESSAGE, 
					null,
					null,
					null
				);
			}
		}
		
	}
}
