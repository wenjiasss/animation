import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This class represents the sample animations panel
 * 
 * @author Wenjia Song
 * @version 1.0
 * @date 5.19.20
 *
 */
public class SampleAnimation extends JPanel {
	
	public SampleAnimation() {
		super();
		setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);
	    g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
	    g.drawString("Sample Animations / Ideas to Try Out", getWidth() * 4 / 23, getHeight() / 10);

		Image image = new ImageIcon("images/Drawing.GIF").getImage();
		g.drawImage(image, 500, 125, 300, 400, this);
		
		Image image2 = new ImageIcon("images/StickmanMoving.gif").getImage();
		g.drawImage(image2, 250, 125, 300, 400, this);

		Image image3 = new ImageIcon("images/Title.GIF").getImage();
		g.drawImage(image3, 10, 125, 300, 400, this);
	  }
}
