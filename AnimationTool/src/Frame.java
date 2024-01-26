
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 * This class represents a Frame in which the user can draw on.
 * 
 * @author Sofia Violet
 * @version 4.0
 * @date 5.18.20
 *
 */
public class Frame extends JPanel implements MouseListener, MouseMotionListener {

	// FIELDS
	private ArrayList<Point> red1;
	private ArrayList<Point> red2;
	private ArrayList<Point> red3;
	
	private ArrayList<Point> green1;
	private ArrayList<Point> green2;
	private ArrayList<Point> green3;
	
	private ArrayList<Point> blue1;
	private ArrayList<Point> blue2;
	private ArrayList<Point> blue3;
	
	private ArrayList<Point> black1;
	private ArrayList<Point> black2;
	private ArrayList<Point> black3;
	
	private ArrayList<Point> yellow1;
	private ArrayList<Point> yellow2;
	private ArrayList<Point> yellow3;
	
	private Color currentColor;
	private int currentStroke;
	private int number;
	// CONSTRUCTOR
	/**
	 * Creates a new blank, white Frame
	 */
	public Frame(int num) {
		setBackground(Color.white);
		number = num;
		red1 = new ArrayList<Point>();
		red2 = new ArrayList<Point>();
		red3 = new ArrayList<Point>();
		
		blue1 = new ArrayList<Point>();
		blue2 = new ArrayList<Point>();
		blue3 = new ArrayList<Point>();
		
		black1 = new ArrayList<Point>();
		black2 = new ArrayList<Point>();
		black3 = new ArrayList<Point>();
		
		green1 = new ArrayList<Point>();
		green2 = new ArrayList<Point>();
		green3 = new ArrayList<Point>();
		
		yellow1 = new ArrayList<Point>();
		yellow2 = new ArrayList<Point>();
		yellow3 = new ArrayList<Point>();
				
		currentColor = Color.black;
		currentStroke = 1;
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	// METHODS

	/**
	 * Draws all the dots on the Frame in the correct color and stroke.
	 * 
	 * @param g The Graphics object being drawn to
	 * @post The dots and lines drawn by the user will be drawn
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		g.drawString("" + number, 10, 30);
		
		g.setColor(Color.red);
		for (int i = 0; i < red1.size(); i++) {
			g.fillOval((int) red1.get(i).getX(), (int) red1.get(i).getY(), 5, 5);
		}
		for (int i = 0; i < red2.size(); i++) {
			g.fillOval((int) red2.get(i).getX(), (int) red2.get(i).getY(), 10, 10);
		}
		for (int i = 0; i < red3.size(); i++) {
			g.fillOval((int) red3.get(i).getX(), (int) red3.get(i).getY(), 15, 15);
		}
		
		
		g.setColor(Color.blue);
		for (int i = 0; i < blue1.size(); i++) {
			g.fillOval((int) blue1.get(i).getX(), (int) blue1.get(i).getY(), 5, 5);
		}
		for (int i = 0; i < blue2.size(); i++) {
			g.fillOval((int) blue2.get(i).getX(), (int) blue2.get(i).getY(), 10, 10);
		}
		for (int i = 0; i < blue3.size(); i++) {
			g.fillOval((int) blue3.get(i).getX(), (int) blue3.get(i).getY(), 15, 15);
		}
		
		
		g.setColor(Color.green);
		for (int i = 0; i < green1.size(); i++) {
			g.fillOval((int) green1.get(i).getX(), (int) green1.get(i).getY(), 5, 5);
		}
		for (int i = 0; i < green2.size(); i++) {
			g.fillOval((int) green2.get(i).getX(), (int) green2.get(i).getY(), 10, 10);
		}
		for (int i = 0; i < green3.size(); i++) {
			g.fillOval((int) green3.get(i).getX(), (int) green3.get(i).getY(), 15, 15);
		}
		
		g.setColor(Color.yellow);
		for (int i = 0; i < yellow1.size(); i++) {
			g.fillOval((int) yellow1.get(i).getX(), (int) yellow1.get(i).getY(), 5, 5);
		}
		for (int i = 0; i < yellow2.size(); i++) {
			g.fillOval((int) yellow2.get(i).getX(), (int) yellow2.get(i).getY(), 10, 10);
		}
		for (int i = 0; i < yellow3.size(); i++) {
			g.fillOval((int) yellow3.get(i).getX(), (int) yellow3.get(i).getY(), 15, 15);
		}

		g.setColor(Color.black);
		for (int i = 0; i < black1.size(); i++) {
			g.fillOval((int) black1.get(i).getX(), (int) black1.get(i).getY(), 5, 5);
		}
		for (int i = 0; i < black2.size(); i++) {
			g.fillOval((int) black2.get(i).getX(), (int) black2.get(i).getY(), 10, 10);
		}
		for (int i = 0; i < black3.size(); i++) {
			g.fillOval((int) black3.get(i).getX(), (int) black3.get(i).getY(), 15, 15);
		}
	}

	/**
	 * Sets the color of the dots and lines being drawn by the user
	 * 
	 * @param c the color wanting to be used to draw with
	 */
	public void setColor(Color color) {
		currentColor = color;
	}

	/**
	 * Sets the stroke thickness of the lines
	 * 
	 * @param s stroke thickness
	 */
	public void setStroke(int s) {
		currentStroke = s;
	}

	/**
	 * Returns this Frame
	 * 
	 * @return the Frame
	 */
	public Frame getFrame() {
		return this;
	}

	/**
	 * Sets the number of the frame to be drawn on to newNum
	 * @param newNum the new number of the frame
	 */
	public void setNumber(int newNum) {
		number = newNum;
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * When the mouse is pressed, a point with the x and y coordinates of the mouse
	 * is drawn on the Frame with the correct color and stroke.
	 * 
	 * @param MouseEvent e
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(currentColor.equals(Color.red) && currentStroke == 1)
			red1.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.red) && currentStroke == 2)
			red2.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.red) && currentStroke == 3)
			red3.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.black) && currentStroke == 1)
			black1.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.black) && currentStroke == 2)
			black2.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.black) && currentStroke == 3)
			black3.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.blue) && currentStroke == 1)
			blue1.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.blue) && currentStroke == 2)
			blue2.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.blue) && currentStroke == 3)
			blue3.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.green) && currentStroke == 1)
			green1.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.green) && currentStroke == 2)
			green2.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.green) && currentStroke == 3)
			green3.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.yellow) && currentStroke == 1)
			yellow1.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.yellow) && currentStroke == 2)
			yellow2.add(new Point(e.getX(), e.getY()));
		else
			yellow3.add(new Point(e.getX(), e.getY()));
		
		repaint();
	}

	/**
	 * When the mouse is released, a point with the x and y coordinates of the mouse
	 * is drawn on the Frame.
	 * 
	 * @param MouseEvent e
	 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * When the mouse is dragged, at each point the mouse drags over, a point is
	 * drawn with the correct x and y values with the correct color and stroke.
	 * 
	 * @param MouseEvent e
	 */
	public void mouseDragged(MouseEvent e) {

		if(currentColor.equals(Color.red) && currentStroke == 1)
			red1.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.red) && currentStroke == 2)
			red2.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.red) && currentStroke == 3)
			red3.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.black) && currentStroke == 1)
			black1.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.black) && currentStroke == 2)
			black2.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.black) && currentStroke == 3)
			black3.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.blue) && currentStroke == 1)
			blue1.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.blue) && currentStroke == 2)
			blue2.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.blue) && currentStroke == 3)
			blue3.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.green) && currentStroke == 1)
			green1.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.green) && currentStroke == 2)
			green2.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.green) && currentStroke == 3)
			green3.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.yellow) && currentStroke == 1)
			yellow1.add(new Point(e.getX(), e.getY()));
		else if(currentColor.equals(Color.yellow) && currentStroke == 2)
			yellow2.add(new Point(e.getX(), e.getY()));
		else
			yellow3.add(new Point(e.getX(), e.getY()));
		
		
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Copies this Frame
	 * @return a Frame with the exact same drawings on it
	 */
	public Frame copyFrame(int num) {
		Frame copy = new Frame(num);
		copy.setRed1(red1);
		copy.setRed2(red2);
		copy.setRed3(red3);
		
		copy.setGreen1(green1);
		copy.setGreen2(green2);
		copy.setGreen3(green3);
		
		copy.setBlue1(blue1);
		copy.setBlue2(blue2);
		copy.setBlue3(blue3);
		
		copy.setYellow1(yellow1);
		copy.setYellow2(yellow2);
		copy.setYellow3(yellow3);
		
		copy.setBlack1(black1);
		copy.setBlack2(black2);
		copy.setBlack3(black3);
		
		return copy;
	}
	
	private void setRed1(ArrayList<Point> r) {
		red1 = r;
	}
	private void setRed2(ArrayList<Point> r) {
		red2 = r;
	}
	private void setRed3(ArrayList<Point> r) {
		red3 = r;
	}
	
	private void setBlack1(ArrayList<Point> r) {
		black1 = r;
	}
	private void setBlack2(ArrayList<Point> r) {
		black2 = r;
	}	
	private void setBlack3(ArrayList<Point> r) {
		black3 = r;
	}
	
	private void setBlue1(ArrayList<Point> r) {
		blue1 = r;
	}
	private void setBlue2(ArrayList<Point> r) {
		blue2 = r;
	}	
	private void setBlue3(ArrayList<Point> r) {
		blue3 = r;
	}
	
	private void setGreen1(ArrayList<Point> r) {
		green1 = r;
	}
	private void setGreen2(ArrayList<Point> r) {
		green2 = r;
	}	
	private void setGreen3(ArrayList<Point> r) {
		green3 = r;
	}
	
	private void setYellow1(ArrayList<Point> r) {
		yellow1 = r;
	}
	private void setYellow2(ArrayList<Point> r) {
		yellow2 = r;
	}	
	private void setYellow3(ArrayList<Point> r) {
		yellow3 = r;
	}

}
