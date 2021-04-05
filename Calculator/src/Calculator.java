import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addBtn,subBtn,multiplyBtn,divideBtn;
	JButton decimalBtn, equalBtn, deleteBtn, clearBtn, negativeBtn;
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculator() {
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myFont);
		textField.setEditable(false);// disable manual text input
		
		addBtn = new JButton("+");
		subBtn = new JButton("-");
		multiplyBtn = new JButton("*");
		divideBtn = new JButton("/");
		decimalBtn = new JButton(".");
		equalBtn = new JButton("=");
		deleteBtn = new JButton("DEL");
		clearBtn = new JButton("CE");
		negativeBtn = new JButton("(-)");
		
		functionButtons[0] = addBtn;
		functionButtons[1] = subBtn;
		functionButtons[2] = multiplyBtn;
		functionButtons[3] = divideBtn;
		functionButtons[4] = decimalBtn;
		functionButtons[5] = equalBtn;
		functionButtons[6] = deleteBtn;
		functionButtons[7] = clearBtn;
		functionButtons[8] = negativeBtn;
		
		// add action listeners
		for(int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		// anonymous number btns
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		// display clear,delete btn a the bottom of the frame
		negativeBtn.setBounds(50, 430, 100, 50);
		deleteBtn.setBounds(150, 430, 100, 50);
		clearBtn.setBounds(250, 430, 100, 50);
		
		// create a seperate panel to host other btns
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.gray);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addBtn);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subBtn);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multiplyBtn);
		panel.add(decimalBtn);
		panel.add(numberButtons[0]);
		panel.add(equalBtn);
		panel.add(divideBtn);
		
		// add components to frame
		frame.add(panel);
		frame.add(negativeBtn);
		frame.add(deleteBtn);
		frame.add(clearBtn);
		frame.add(textField);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		/**
		 * A Calculator App
		 * ----------------
		 */
		Calculator calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// numberBtns event
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				// populate the textfield with the number clicked
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		// decimalBtn event
		if(e.getSource() == decimalBtn) {
			// add . at the end of text
			textField.setText(textField.getText().concat("."));
		}

		// addBtn event
		if(e.getSource() == addBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		
		// subBtn event
		if(e.getSource() == subBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		
		// multiplyBtn event
		if(e.getSource() == multiplyBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		
		// divideBtn event
		if(e.getSource() == divideBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}

		// equalsBtn event
		if(e.getSource() == equalBtn) {
			num2 = Double.parseDouble(textField.getText());

			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;

			default:
				break;
			}
			
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		
		// clearBtn event
		if(e.getSource() == clearBtn) {
			textField.setText("");
		}

		// deleteBtn event
		if(e.getSource() == deleteBtn) {
			String string = textField.getText();
			textField.setText("");
			for (int i = 0; i < string.length() -1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
				// delete the last item in the textfield
			}
		}

		// negativeBtn event
		if(e.getSource() == negativeBtn) {
			Double temp = Double.parseDouble(textField.getText());
			temp*= -1; // flip the value to a negative value
			textField.setText(String.valueOf(temp));
		}

	}

}
