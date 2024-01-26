
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class represents the Menu screen when the program is first run.
 * 
 * @author Sofia Violet
 * @version 2.0
 * @date 5.21.20
 *
 */
public class Menu extends JPanel implements ActionListener {

	private Window w;

	/**
	 * Creates a new Menu that displays the drawing window as well as the
	 * instructions
	 * 
	 * @param w
	 */
	public Menu(Window w) {
		setBackground(Color.white);
		this.w = w;
		JPanel p = new JPanel();

		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		// p.add(Box.createVerticalStrut(300));

		JButton button = new JButton("New Animation!");
		button.addActionListener(this);
		p.add(button);
		add(p);

		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		JButton button2 = new JButton("Sample Animations");
		button2.addActionListener(this);
		p.add(button2);
		add(p);

	}

	/**
	 * Draws instructions and images on the menu
	 * 
	 * @param g Graphics object being drawn on
	 * @post instructions and images are displayed on the menu
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("images/stickFigure.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image, 50, 125, 190, 400, null);

		int width = getWidth();
		int height = getHeight() + 200;

		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString("Animation Maker! Make your own Animations.", width * 4 / 23, height / 10);

		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("Use the mouse to draw by clicking and dragging.", 3 * width / 10 - 20, height / 10 + 30);
		g.drawString("Press m to return to this screen", 3 * width / 10 + 20, height / 10 + 60);
		g.drawLine(3 * width / 10, height / 10 + 75, 3 * width / 10 + 600, height / 10 + 75);

		g.drawString("Main Functions: ", 3 * width / 10 + 70, height / 3 - 80);
		g.drawString("Tools: ", 3 * width / 10 + 150, height / 3 + 70);
		g.drawString("Stroke Thickness: ", 3 * width / 10 + 55, height / 3 + 220);
		g.drawString("Speed: ", 3 * width / 10 + 142, height / 3 + 250);

		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("space - play animation", 3 * width / 10 + 220, height / 3 - 80);
		g.drawString("backspace - delete a frame", 3 * width / 10 + 220, height / 3 - 50);
		g.drawString("left arrow- move back a frame", 3 * width / 10 + 220, height / 3 - 20);
		g.drawString("right arrow - move forward a frame", 3 * width / 10 + 220, height / 3 + 10);
		g.drawString("c - copy current frame", 3 * width / 10 + 220, height / 3 + 40);


		// colors
		g.drawString("b - black", 3 * width / 10 + 220, height / 3 + 70);
		g.setColor(Color.red);
		g.drawString("r - red", 3 * width / 10 + 220, height / 3 + 100);
		g.setColor(new Color(230, 200, 0));
		g.drawString("y - yellow", 3 * width / 10 + 220, height / 3 + 130);
		g.setColor(Color.green);
		g.drawString("g - green", 3 * width / 10 + 220, height / 3 + 160);
		g.setColor(Color.blue);
		g.drawString("l - blue", 3 * width / 10 + 220, height / 3 + 190);

		g.setColor(Color.black);
		g.drawString("1, 2, or 3", 3 * width / 10 + 220, height / 3 + 220);
		g.drawString("up arrow to increase speed", 3 * width / 10 + 220, height / 3 + 250);
		g.drawString("down arrow to decrease speed", 3 * width / 10 + 220, height / 3 + 280);
		
	

	}

	/**
	 * Changes panel
	 * 
	 * @param e the event performed
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("New Animation!"))
			w.changePanel("0");

		if (e.getActionCommand().equals("Sample Animations"))
			w.changePanel("sample");
	}

}
