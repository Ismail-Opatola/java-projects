import java.awt.Color;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

//	private static final long serialVersionUID = 1L;
	GamePanel panel;
	
	public GameFrame() {
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("Pong Game");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack(); // fit the size of its subcomponents
		this.setVisible(true);
		this.setLocationRelativeTo(null); // appear in the middle of the screen
	}
}
