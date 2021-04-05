import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Stopwatch implements ActionListener {

	JFrame frame = new JFrame();
	JButton startBtn = new JButton("START");
//	JButton stopBtn = new JButton("STOP");
	JButton resetBtn = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int secs = 0;
	int mins = 0;
	int hrs = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", secs); 
	String mins_string = String.format("%02d", mins); 
	String hrs_string = String.format("%02d", hrs); 
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			/**
			 * increse elapsedTime by 1s
			 * determine amount of hrs,mins,secs that have passed
			 * update timeLabel component
			 */
			elapsedTime += 1000;
			
			hrs = (elapsedTime/3600000); // (elapsedTime/theAmountOfMillisecondsIn1hour)
			mins = (elapsedTime/60000) % 60; // (elapsedTime/theAmountOfMillisecondsIn1Min)
			secs = (elapsedTime/1000) % 60;
			
			hrs_string = String.format("%02d", hrs);
			mins_string = String.format("%02d", mins);
			seconds_string = String.format("%02d", secs);
					
			timeLabel.setText(hrs_string+ ":" + mins_string + ":" + seconds_string);

		}
	}); // every 1s
	
	Stopwatch() {
	
		timeLabel.setText(hrs_string+ ":" + mins_string + ":" + seconds_string);
		timeLabel.setBounds(100,100, 200, 100);
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startBtn.setBounds(100,200,100,50);
		startBtn.setFont(new Font("Ink Free", Font.PLAIN, 20));
		startBtn.setFocusable(false);
		startBtn.addActionListener(this);
		
		resetBtn.setBounds(200,200,100,50);
		resetBtn.setFont(new Font("Ink Free", Font.PLAIN, 20));
		resetBtn.setFocusable(false);
		resetBtn.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		
		frame.add(timeLabel);		
		frame.add(startBtn);		
		frame.add(resetBtn);		
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == startBtn) {
			if(started == false) {
				started = true;
				startBtn.setText("STOP");
				start();
			} else {
				started = false;
				startBtn.setText("START");
				stop();
			}
			
		}
		if(e.getSource() == resetBtn) {
			started = false;
			startBtn.setText("START");
			reset();
		}
	}
	
	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}
		
	void reset() {
		timer.stop();
		elapsedTime = 0;
		secs = 0;
		mins = 0;
		hrs = 0;
		
		hrs_string = String.format("%02d", hrs);
		mins_string = String.format("%02d", mins);
		seconds_string = String.format("%02d", secs);
		
		timeLabel.setText(hrs_string+ ":" + mins_string + ":" + seconds_string);
	}
}
