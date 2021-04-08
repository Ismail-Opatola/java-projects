import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Quiz implements ActionListener {

	String[] questions = {
		"Which company created Java?",
		"Which year eas Java created?",
		"What was Java originally called?"
	};
	String[][] options = {
		{"Sun Microsystem", "Starbucks", "Microsoft", "Alphabet"},
		{"1989", "1996", "1972", "1492"},
		{"Apple", "Latte", "Oak", "Koffing"}
	};
	char[] answers = {
		'A', 'B', 'C'
	};
	char guess, answer;
	int index, // question index 
		correct_guesses = 0, 
		total_questions = questions.length, 
		result, seconds = 10;
	
	JFrame frame = new JFrame();
	JTextField textField = new JTextField();
	JTextArea textArea = new JTextArea();
	JButton btnA = new JButton("A");
	JButton btnB = new JButton("B");
	JButton btnC = new JButton("C");
	JLabel answerALabel = new JLabel();
	JLabel answerBLabel = new JLabel();
	JLabel answerCLabel = new JLabel();
	JLabel timeLabel = new JLabel();
	JLabel secondsLeftLabel = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	// time question, if not answered, markAsFailed
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			secondsLeftLabel.setText(String.valueOf(seconds));
			if(seconds <= 0) {
				displayAnswer();
			}
		}
	});
	
	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setResizable(false);
		
		textField.setBounds(0,0,650,50);
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Ink Free", Font.BOLD,30));
		textField.setBorder(BorderFactory.createBevelBorder(1));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setEditable(false);
		
		textArea.setBounds(0,50,650,50);
		textArea.setBackground(new Color(25,25,25));
		textArea.setForeground(new Color(25,255,0));
		textArea.setFont(new Font("MV Boli", Font.BOLD,25));
		textArea.setBorder(BorderFactory.createBevelBorder(1));
		textArea.setEditable(false);
		
		btnA.setBounds(0,100,100,100);
		btnA.setFont(new Font("MV Boli", Font.BOLD, 35));
		btnA.setFocusable(false);
		btnA.addActionListener(this);
		
		btnB.setBounds(0,200,100,100);
		btnB.setFont(new Font("MV Boli", Font.BOLD, 35));
		btnB.setFocusable(false);
		btnB.addActionListener(this);
		
		btnC.setBounds(0,300,100,100);
		btnC.setFont(new Font("MV Boli", Font.BOLD, 35));
		btnC.setFocusable(false);
		btnC.addActionListener(this);
		
		answerALabel.setBounds(125,100,500,100);
		answerALabel.setBackground(new Color(50,50,50));
		answerALabel.setForeground(new Color(25,255,0));
		answerALabel.setFont(new Font("MV Boli", Font.PLAIN, 35));
		
		answerBLabel.setBounds(125,200,500,100);
		answerBLabel.setBackground(new Color(50,50,50));
		answerBLabel.setForeground(new Color(25,255,0));
		answerBLabel.setFont(new Font("MV Boli", Font.PLAIN, 35));
		
		answerCLabel.setBounds(125,300,500,100);
		answerCLabel.setBackground(new Color(50,50,50));
		answerCLabel.setForeground(new Color(25,255,0));
		answerCLabel.setFont(new Font("MV Boli", Font.PLAIN, 35));
		
		secondsLeftLabel.setBounds(535,510,100,100);
		secondsLeftLabel.setBackground(new Color(25,25,25));
		secondsLeftLabel.setForeground(new Color(255,0,0));
		secondsLeftLabel.setFont(new Font("Ink Free", Font.BOLD, 60));
		secondsLeftLabel.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeftLabel.setOpaque(true);
		secondsLeftLabel.setHorizontalAlignment(JTextField.CENTER);
		secondsLeftLabel.setText(String.valueOf(seconds));
		
		timeLabel.setBounds(535,475,100,25);
		timeLabel.setBackground(new Color(50, 50, 50));
		timeLabel.setForeground(new Color(255,0,0));
		timeLabel.setFont(new Font("MV Boli", Font.PLAIN, 16));
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		timeLabel.setText("timer >:D");
		
		number_right.setBounds(225,225,200,100);;
		number_right.setBackground(new Color(25,25, 25));
		number_right.setForeground(new Color(25, 255, 25));
		number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25, 25));
		percentage.setForeground(new Color(25, 255, 25));
		percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		frame.add(timeLabel);
		frame.add(secondsLeftLabel);
		frame.add(answerALabel);
		frame.add(answerBLabel);
		frame.add(answerCLabel);
		frame.add(btnA);
		frame.add(btnB);
		frame.add(btnC);
		frame.add(textArea);
		frame.add(textField);
		frame.setVisible(true);
		
		nextQuestion();
	}
	private void nextQuestion() {
		
		if(index >= total_questions) {
			results();
		} else {
			textField.setText("Question " + (index + 1));
			textArea.setText(questions[index]);
			answerALabel.setText(options[index][0]);
			answerBLabel.setText(options[index][1]);
			answerCLabel.setText(options[index][2]);
			timer.start(); // time question, if not answered, markAsFailed
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		btnA.setEnabled(false);
		btnB.setEnabled(false);
		btnC.setEnabled(false);
		
		if(e.getSource() == btnA) {
			answer = 'A';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		if(e.getSource() == btnB) {
			answer = 'B';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		if(e.getSource() == btnC) {
			answer = 'C';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		displayAnswer();
	}
	private void displayAnswer() {
		timer.stop();
		btnA.setEnabled(false);
		btnB.setEnabled(false);
		btnC.setEnabled(false);
		
		if(answers[index] != 'A') 
			answerALabel.setForeground(new Color(255, 0, 0));
		if(answers[index] != 'B') 
			answerBLabel.setForeground(new Color(255, 0, 0));
		if(answers[index] != 'C') 
			answerCLabel.setForeground(new Color(255, 0, 0));
		
		// set timer with 2s delay and a callback 
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// change feilds back to green
				answerALabel.setForeground(new Color(25,255,0));
				answerBLabel.setForeground(new Color(25,255,0));
				answerCLabel.setForeground(new Color(25,255,0));
				
				// reset
				answer = ' ';
				seconds = 10;
				secondsLeftLabel.setText(String.valueOf(seconds));
				
				// enable btns
				btnA.setEnabled(true);
				btnB.setEnabled(true);
				btnC.setEnabled(true);
				
				// go to the next question
				index++;
				nextQuestion();
			}
		});
		
		/**
		 * execute timer only once per displayAnswer function call
		 * by disabling repeats so it won't be called every 2s
		 * we only need it to -delay for 2s and- execute only once
		 */
		pause.setRepeats(false);
		pause.start();
	}
	private void results() {
		btnA.setEnabled(false);
		btnB.setEnabled(false);
		btnC.setEnabled(false);
		
		// calculate score
		result = (int)((correct_guesses / (double) total_questions) * 100);
		
		// clear view
		textField.setText("RESULTS!");
		textArea.setText("");
		answerALabel.setText("");
		answerBLabel.setText("");
		answerCLabel.setText("");
		
		// set score
		number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
		percentage.setText(result + "%");
		
		frame.add(percentage);
		frame.add(number_right);
		
	}
}
