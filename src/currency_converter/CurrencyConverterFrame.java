package currency_converter;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CurrencyConverterFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CurrencyConverterFrame(int WIDTH, int HEIGHT, String title, String iconPath, Color backgroundColor) {
		this.setSize(WIDTH, HEIGHT);
		this.setTitle(title);
		this.setResizable(false);
		this.setLocation((int)Math.floor(WIDTH / 2.0), (int)Math.floor(HEIGHT / 2.0 - HEIGHT / 4.0));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
        
        ImageIcon icon = new ImageIcon(iconPath);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(backgroundColor);
	}
	
}
