
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class represents a window. It displays the timeline.
 * 
 * @author Wenjia Song
 * @version 2.0
 * @date 5.5.20
 *
 */

public class Window extends JFrame implements KeyListener {

	// FIELDS
	private Timeline t;

	private int currentFrameIndex;
	private int animationIndex = 0;
	private JPanel cardPanel;
	private Timer timer;
	private Color c;
	private int stroke;
	private int delay;

	/**
	 * Creates a new Window with the name title, adds a Timeline and Frame to the
	 * window
	 * 
	 * @param title
	 */
	// CONSTRUCTOR
	public Window(String title) {
		super(title);
		t = new Timeline();
		c = Color.black;
		stroke = 1;
		currentFrameIndex = 0;
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);

		Frame panel1 = new Frame(1);
		Menu menu = new Menu(this);
		SampleAnimation sample = new SampleAnimation();

		cardPanel.add(menu, "menu");
		cardPanel.add(panel1, "0");
		cardPanel.add(sample, "sample");

		t.addFrame(panel1);
		addKeyListener(this);
		add(cardPanel);
		setVisible(true);
		setFocusable(true);
		setResizable(false);
		requestFocus();

		delay = 100;
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (animationIndex < t.getFrameList().size()) {
					changePanel("" + animationIndex);
					animationIndex++;
				} else {
					animationIndex = 0;
					timer.stop();
				}
			}
		};
		timer = new Timer(delay, taskPerformer);
	}

	// METHODS

	/**
	 * Returns an instance of the Timeline class used
	 * 
	 * @return instance of Timeline class used
	 */
	public Timeline getTimeline() {
		return t;
	}

	/**
	 * Moves to a different frame, runs animation, deletes frame, or changes marker
	 * color of next frame depending on key pressed by user
	 * 
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		requestFocus();
		// right arrow (forward a frame)
		if (e.getKeyCode() == 39) {
			currentFrameIndex += 1;
			if (currentFrameIndex >= t.getFrameList().size() - 1) {
				String newName = "" + (currentFrameIndex);
				Frame newFrame = new Frame(currentFrameIndex+1);
				cardPanel.add(newFrame, newName);
				t.addFrame(newFrame);
				changePanel(newName);
			} else {
				changePanel("" + currentFrameIndex);
			}
		}

		//Up Arrow
		if(e.getKeyCode() == 38) {
			if(delay > 40)
				delay -=20;
			ActionListener taskPerformer = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (animationIndex < t.getFrameList().size()) {
						changePanel("" + animationIndex);
						animationIndex++;
					} else {
						animationIndex = 0;
						timer.stop();
					}
				}
			};
			timer = new Timer(delay, taskPerformer);
		}

		//Down Arrow
		if(e.getKeyCode() == 40) {
			if(delay < 3000)
				delay +=20;
			ActionListener taskPerformer = new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (animationIndex < t.getFrameList().size()) {
						changePanel("" + animationIndex);
						animationIndex++;
					} else {
						animationIndex = 0;
						timer.stop();
					}
				}
			};
			timer = new Timer(delay, taskPerformer);
		}

		//copies the current frame and shows the new frame
		if(e.getKeyCode() == 67) {
			currentFrameIndex+=1;
			String newName = "" + (currentFrameIndex);
			Frame newFrame = t.getFrame(currentFrameIndex).copyFrame(currentFrameIndex+1);
			cardPanel.add(newFrame, newName);
			t.addFrame(newFrame);
			changePanel(newName);
		}
		// left key code (backward a frame)
		else if (e.getKeyCode() == 37) {
			if (currentFrameIndex == 0)
				return;
			currentFrameIndex -= 1;
			changePanel("" + currentFrameIndex);
		}
		// space (run animation)
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			timer.start();
		}

		// backspace (deletes current frame)
		else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (currentFrameIndex > 0) {
				cardPanel.remove(currentFrameIndex);
				t.getFrameList().remove(currentFrameIndex);
				currentFrameIndex -= 1;
				changePanel("" + currentFrameIndex);
			} else {
				cardPanel.remove(0);
				String newName = "" + (currentFrameIndex);
				Frame newFrame = new Frame(currentFrameIndex+1);
				cardPanel.add(newFrame, newName);
				t.addFrame(newFrame);
				t.getFrameList().remove(currentFrameIndex);
				changePanel(newName);
			}
		}

		if (e.getKeyCode() == 66) // b
			c = Color.black;
		if (e.getKeyCode() == 82) // r
			c = Color.red;
		if (e.getKeyCode() == 89) // y
			c = Color.yellow;
		if (e.getKeyCode() == 71) // g
			c = Color.green;
		if (e.getKeyCode() == 76) // l
			c = Color.blue;

		if (e.getKeyCode() == 49) // 1
			stroke = 1;
		if (e.getKeyCode() == 50) // 2
			stroke = 2;
		if (e.getKeyCode() == 51) // 2
			stroke = 3;

		t.getFrame(currentFrameIndex+1).setColor(c);
		t.getFrame(currentFrameIndex+1).setStroke(stroke);
		t.getFrame(currentFrameIndex+1).repaint();

		if (e.getKeyCode() == 77) // m
			changePanel("menu");

	}

	/**
	 * Changes to a different component
	 * 
	 * @param name name of panel
	 */
	public void changePanel(String name) {
		((CardLayout) cardPanel.getLayout()).show(cardPanel, name);
		requestFocus();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
