import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
//	private static final long serialVersionUID = 1L;
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555)); // (5/9) = 0.5555
	static final Dimension SCREE_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	public static final int BALL_DIAMETER = 20;
	public static final int PADDLE_WIDTH = 25;
	public static final int PADDLE_HEIGHT = 100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score score;
	
	public GamePanel() {
		newPeddles();
		newBall();
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREE_SIZE);
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	private void newBall() {
		random = new Random();
//		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2), (GAME_HEIGHT/2)-(BALL_DIAMETER/2), BALL_DIAMETER, BALL_DIAMETER);		
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2), random.nextInt((GAME_HEIGHT - BALL_DIAMETER)), BALL_DIAMETER, BALL_DIAMETER);		
	}
	
	public void newPeddles() {
		paddle1 = new Paddle(0, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
	}

	public void move() {
		paddle1.move();
		paddle2.move();
		 ball.move();
	}
	
	public void checkCollision() {
		/**
		 * bounce ball off top & bottom window edges
		 */
		if(ball.y <= 0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		/**
		 * bounces ball off paddels
		 */
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; // (optional) - increase speed for more difficulty
			
			if(ball.yVelocity > 0 )
				ball.yVelocity++;
			else
				ball.yVelocity--;
			
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if(ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; // (optional) - increase speed for more difficulty
			
			if(ball.yVelocity > 0 )
				ball.yVelocity++;
			else
				ball.yVelocity--;
			
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(-ball.yVelocity);
		}
		/**
		 * stops paddles @ window edges
		 */
		if(paddle1.y <= 0) 
			paddle1.y=0;
		if(paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
			paddle1.y = (GAME_HEIGHT - PADDLE_HEIGHT);
		if(paddle2.y <= 0) 
			paddle2.y=0;
		if(paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
			paddle2.y = (GAME_HEIGHT - PADDLE_HEIGHT);
		/**
		 * Give player 1 point and create new paddles & ball
		 */
		if(ball.x <= 0) {
			score.player2++;
			newPeddles();
			newBall();
		}
		if(ball.x >= GAME_WIDTH - BALL_DIAMETER) {
			score.player1++;
			newPeddles();
			newBall();
		}
	}
	
	public void run() {
		// game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			if(delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	
	// Action Listener
	public class AL extends KeyAdapter {
		
		public void KeyPressed(KeyEvent e) {
			paddle1.KeyPressed(e);
			paddle2.KeyPressed(e);
		}
		
		public void KeyReleased(KeyEvent e) {
			paddle1.KeyReleased(e);
			paddle2.KeyReleased(e);
		}
	}
}
