package currency_converter;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
		
		JPanel convertFromTitlePanel = new JPanel();
		convertFromTitlePanel.setBackground(backgroundColor);
		convertFromTitlePanel.setBounds(0, HEIGHT / 4, WIDTH / 2, HEIGHT / 8);
		
		JPanel convertFromPanel = new JPanel();
		convertFromPanel.setBackground(backgroundColor);
		convertFromPanel.setBounds(0, HEIGHT / 4 + 80, WIDTH / 2, HEIGHT / 8);
		
		JPanel convertToTitlePanel = new JPanel();
		convertToTitlePanel.setBackground(backgroundColor);
		convertToTitlePanel.setBounds(WIDTH / 2, HEIGHT / 4, WIDTH / 2, HEIGHT / 8);
		
		JPanel convertToPanel = new JPanel();
		convertToPanel.setBackground(backgroundColor);
		convertToPanel.setBounds(WIDTH / 2, HEIGHT / 4 + 80, WIDTH / 2, HEIGHT / 8);
		
		JPanel convertButtonPanel = new JPanel();
		convertButtonPanel.setBackground(backgroundColor);
		convertButtonPanel.setBounds(0, HEIGHT / 2, WIDTH, HEIGHT / 8);
		
		JPanel resultPanel = new JPanel();
		resultPanel.setBackground(backgroundColor);
		resultPanel.setBounds(0, HEIGHT / 2 + HEIGHT / 8, WIDTH, HEIGHT / 8);
		
		JPanel apiKeyPanel = new JPanel();
		apiKeyPanel.setBackground(backgroundColor);
		apiKeyPanel.setBounds(0, HEIGHT / 2 + HEIGHT / 8 + 80, WIDTH, HEIGHT / 8);
		
		JLabel titleLabel = new JLabel(title);
        titleLabel.setBounds(0, 0, WIDTH, HEIGHT / 8);
		titleLabel.setFont(new Font("Liberation Mono", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);	
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleLabel.getFont().deriveFont(30.0f));
		titleLabel.setForeground(new Color(0, 255, 0));
		titlePanel.add(titleLabel);	
		
		JLabel labelForTextFieldInput = new JLabel("Enter amount to convert  ");
		labelForTextFieldInput.setBounds(0, 0, WIDTH, HEIGHT / 8);
		labelForTextFieldInput.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
		labelForTextFieldInput.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new LineBorder(Color.GREEN, 2)));
		labelForTextFieldInput.setFont(new Font("Liberation Mono", Font.PLAIN, 20));
		labelForTextFieldInput.setHorizontalAlignment(JLabel.CENTER);
		labelForTextFieldInput.setVerticalAlignment(JLabel.CENTER);
		labelForTextFieldInput.setFont(labelForTextFieldInput.getFont().deriveFont(20.0f));
		labelForTextFieldInput.setForeground(new Color(0, 255, 0));
		greenPanel.add(labelForTextFieldInput);
		
		JTextField textFieldInput = new JTextField("0.0", 6);
		textFieldInput.setBounds(0, HEIGHT / 4, WIDTH, HEIGHT / 8);
		textFieldInput.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
		textFieldInput.setBackground(new Color(0, 255, 0));
		textFieldInput.setHorizontalAlignment(JTextField.CENTER);
		textFieldInput.setFont(textFieldInput.getFont().deriveFont(20.0f));
		textFieldInput.setForeground(new Color(0, 0, 0));
		greenPanel.add(textFieldInput);
		
		JLabel labelForComboBoxFrom = new JLabel("Convert from");
		labelForComboBoxFrom.setBounds(labelForComboBoxFrom.getX(), labelForComboBoxFrom.getY(), WIDTH / 2, HEIGHT / 8);
		labelForComboBoxFrom.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
		labelForComboBoxFrom.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new LineBorder(Color.GREEN, 2)));
		labelForComboBoxFrom.setFont(new Font("Liberation Mono", Font.PLAIN, 20));
		labelForComboBoxFrom.setHorizontalAlignment(JLabel.CENTER);
		labelForComboBoxFrom.setVerticalAlignment(JLabel.CENTER);
		labelForComboBoxFrom.setFont(labelForComboBoxFrom.getFont().deriveFont(20.0f));
		labelForComboBoxFrom.setForeground(new Color(0, 255, 0));
		labelForComboBoxFrom.setBackground(backgroundColor);
		convertFromTitlePanel.add(labelForComboBoxFrom);
		
		JComboBox<String> comboBoxFrom = new JComboBox<String>(currencyCodes);
		comboBoxFrom.setBounds(0, HEIGHT / 4 + 200, WIDTH / 2, HEIGHT / 8);
		comboBoxFrom.setLocation(0, HEIGHT / 4 + 200);
		comboBoxFrom.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
		comboBoxFrom.setBackground(new Color(0, 255, 0));
		comboBoxFrom.setFont(new Font("Liberation Mono", Font.PLAIN, 20));
		comboBoxFrom.setForeground(new Color(0, 0, 0));
		convertFromPanel.add(comboBoxFrom);
		
		JLabel labelForComboBoxTo = new JLabel("Convert to");
		labelForComboBoxTo.setBounds(labelForComboBoxTo.getPreferredSize().width, 0, WIDTH / 2, HEIGHT / 8);
		labelForComboBoxTo.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
		labelForComboBoxTo.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new LineBorder(Color.GREEN, 2)));
		labelForComboBoxTo.setFont(new Font("Liberation Mono", Font.PLAIN, 20));
		labelForComboBoxTo.setHorizontalAlignment(JLabel.CENTER);
		labelForComboBoxTo.setVerticalAlignment(JLabel.CENTER);
		labelForComboBoxTo.setFont(labelForComboBoxTo.getFont().deriveFont(20.0f));
		labelForComboBoxTo.setForeground(new Color(0, 255, 0));
		labelForComboBoxTo.setBackground(backgroundColor);
		convertToTitlePanel.add(labelForComboBoxTo);
		
		JComboBox<String> comboBoxTo = new JComboBox<String>(currencyCodes);
		comboBoxTo.setBounds(0, HEIGHT / 4 + 200, WIDTH / 2, HEIGHT / 8);
		comboBoxTo.setLocation(0, HEIGHT / 4 + 200);
		comboBoxTo.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
		comboBoxTo.setBackground(new Color(0, 255, 0));
		comboBoxTo.setFont(new Font("Liberation Mono", Font.PLAIN, 20));
		comboBoxTo.setForeground(new Color(0, 0, 0));
		convertToPanel.add(comboBoxTo);
		
		JLabel labelForTextFieldResult = new JLabel("Result  ", SwingConstants.CENTER);
		labelForTextFieldResult.setBounds(0, 0, WIDTH, HEIGHT / 8);
		labelForTextFieldResult.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
		labelForTextFieldResult.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new LineBorder(Color.GREEN, 2)));
		labelForTextFieldResult.setFont(new Font("Liberation Mono", Font.PLAIN, 20));
		labelForTextFieldResult.setHorizontalAlignment(JLabel.CENTER);
		labelForTextFieldResult.setVerticalAlignment(JLabel.CENTER);
		labelForTextFieldResult.setFont(labelForTextFieldResult.getFont().deriveFont(20.0f));
		labelForTextFieldResult.setForeground(new Color(0, 255, 0));
		resultPanel.add(labelForTextFieldResult);
		
		JTextField textFieldResult = new JTextField("0.0", 6);
		textFieldResult.setBounds(0, HEIGHT / 4 + HEIGHT / 8, WIDTH, HEIGHT / 8);
		textFieldResult.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
		textFieldResult.setBackground(new Color(0, 255, 0));
		textFieldResult.setHorizontalAlignment(JTextField.CENTER);
		textFieldResult.setFont(textFieldResult.getFont().deriveFont(20.0f));
		textFieldResult.setForeground(new Color(0, 0, 0));
		resultPanel.add(textFieldResult);
		
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(0, 0, WIDTH, HEIGHT / 8);
        convertButton.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
        convertButton.setBackground(new Color(0, 255, 0));
        convertButton.setFont(new Font("Liberation Mono", Font.PLAIN, 20));
        convertButton.setForeground(new Color(0, 0, 0));
        convertButtonPanel.add(convertButton);
        
        JLabel labelForTextFieldApiKey = new JLabel("Enter your API key  ");
        labelForTextFieldApiKey.setBounds
        (0, 0, WIDTH, HEIGHT / 8);
        labelForTextFieldApiKey.setBorder
        (new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
        labelForTextFieldApiKey.setBorder
        (BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new LineBorder(Color.GREEN, 2)));
        labelForTextFieldApiKey.setFont(new Font("Liberation Mono", Font.PLAIN, 20));
        labelForTextFieldApiKey.setHorizontalAlignment(JLabel.CENTER);
        labelForTextFieldApiKey.setVerticalAlignment(JLabel.CENTER);
        labelForTextFieldApiKey.setFont(labelForTextFieldApiKey.getFont().deriveFont(20.0f));
        labelForTextFieldApiKey.setForeground(new Color(0, 255, 0));
        apiKeyPanel.add(labelForTextFieldApiKey);
        
        JTextField textFieldApiKey = new JTextField("key", 6);
		textFieldApiKey.setBounds(0, HEIGHT / 4 + 200, WIDTH, HEIGHT / 8);	
		textFieldApiKey.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
		textFieldApiKey.setBackground(new Color(0, 255, 0));
		textFieldApiKey.setHorizontalAlignment(JTextField.CENTER);
		textFieldApiKey.setFont(textFieldApiKey.getFont().deriveFont(20.0f));
		textFieldApiKey.setForeground(new Color(0, 0, 0));
		apiKeyPanel.add(textFieldApiKey);
		
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
		this.add(convertFromTitlePanel);
		this.add(convertToTitlePanel);
		this.add(convertFromPanel);
		this.add(convertToPanel);
		this.add(convertButtonPanel);
		this.add(resultPanel);
		this.add(apiKeyPanel);
		
        ImageIcon icon = new ImageIcon(iconPath);
        this.setIconImage(icon.getImage());
        
	}
	
}
