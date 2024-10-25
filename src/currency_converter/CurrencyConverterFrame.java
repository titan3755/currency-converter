package currency_converter;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class CurrencyConverterFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CurrencyConverterFrame(int WIDTH, int HEIGHT, String title, String iconPath, Color backgroundColor) {
		this.setSize(WIDTH, HEIGHT);
		this.setTitle(title);
		this.setResizable(false);
		this.setLocation((int)Math.floor(WIDTH / 2.0), (int)Math.floor(HEIGHT / 2.0 - HEIGHT / 4.0));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
        ImageIcon icon = new ImageIcon(iconPath);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(backgroundColor);
        
        JLabel titleLabel = new JLabel();
        titleLabel.setText("Welcome to currency converter");
        titleLabel.setBounds(0, 0, 800, 200);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setSize(800, 200);
        titleLabel.setLocation(titleLabel.getLocation().x, 10);
        titleLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 25));
        titleLabel.setForeground(new Color(0, 0, 0));
        this.add(titleLabel);
        
	}
	
}
