package currency_converter;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CurrencyConverterFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String[] currencyCodes = {"USD", "BDT", "EUR", "GBP", "INR", "JPY", "KRW", "RUB", "TRY", "ZAR", "AUD", "CAD", "CNY", "HKD", "IDR", "MYR", "NZD", "SGD", "THB", "VND", "BRL", "CLP", "MXN", "ARS", "COP", "PEN", "UYU", "EGP", "ILS", "SAR", "AED", "QAR", "KWD", "BHD", "OMR", "JOD", "LBP", "PKR", "PHP", "LKR", "NPR", "DKK", "NOK", "SEK", "CHF", "CZK", "HUF", "PLN", "RON", "HRK", "RSD", "BGN", "ISK", "GEL", "AMD", "AZN", "KZT", "UZS", "TJS", "TMT", "BYN", "MDL", "ALL", "MKD", "BAM", "EUR", "CHF", "GBP", "JPY", "AUD", "CAD", "CNY", "HKD", "IDR", "MYR", "NZD", "SGD", "THB", "VND", "BRL", "CLP", "MXN", "ARS", "COP", "PEN", "UYU", "EGP", "ILS", "SAR", "AED", "QAR", "KWD", "BHD", "OMR", "JOD", "LBP", "PKR", "PHP", "LKR", "NPR", "DKK", "NOK", "SEK", "CHF", "CZK", "HUF", "PLN", "RON", "HRK", "RSD", "BGN", "ISK", "GEL", "AMD", "AZN", "KZT", "UZS", "TJS", "TMT", "BYN", "MDL", "ALL", "MKD", "BAM", "EUR", "CHF", "GBP", "JPY", "AUD", "CAD", "CNY", "HKD", "IDR", "MYR", "NZD", "SGD", "THB", "VND", "BRL"};

	public CurrencyConverterFrame(int WIDTH, int HEIGHT, String title, String iconPath, Color backgroundColor) {
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(backgroundColor);
		titlePanel.setBounds(0, 0, WIDTH, HEIGHT / 8);
		
		JPanel greenPanel = new JPanel();
		greenPanel.setBackground(backgroundColor);
		greenPanel.setBounds(0, HEIGHT / 8, WIDTH, HEIGHT / 8);
		
		JLabel titleLabel = new JLabel(title);
		titleLabel.setBounds(0, 0, WIDTH, HEIGHT / 8);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);	
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleLabel.getFont().deriveFont(30.0f));
		titleLabel.setForeground(new Color(0, 255, 0));
		titlePanel.add(titleLabel);	
		
		this.setSize(WIDTH, HEIGHT);
		this.setTitle(title);
		this.setResizable(false);
		this.setLocation((int)Math.floor(WIDTH / 2.0), (int)Math.floor(HEIGHT / 2.0 - HEIGHT / 4.0));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
        this.getContentPane().setBackground(backgroundColor);
		this.setVisible(true);
		this.add(titlePanel);
		this.add(greenPanel);
		
        ImageIcon icon = new ImageIcon(iconPath);
        this.setIconImage(icon.getImage());
        
        
        
	}
	
}
