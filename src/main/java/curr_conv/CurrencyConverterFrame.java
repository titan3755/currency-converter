package curr_conv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
import javax.swing.event.DocumentListener;

import com.google.gson.*;

public class CurrencyConverterFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final boolean isDebug = true;
	private static final long serialVersionUID = 1L;
	public static final String[] currencyCodes = {"USD", "BDT", "EUR", "GBP", "INR", "JPY", "KRW", "RUB", "TRY", "ZAR", "AUD", "CAD", "CNY", "HKD", "IDR", "MYR", "NZD", "SGD", "THB", "VND", "BRL", "CLP", "MXN", "ARS", "COP", "PEN", "UYU", "EGP", "ILS", "SAR", "AED", "QAR", "KWD", "BHD", "OMR", "JOD", "LBP", "PKR", "PHP", "LKR", "NPR", "DKK", "NOK", "SEK", "CHF", "CZK", "HUF", "PLN", "RON", "HRK", "RSD", "BGN", "ISK", "GEL", "AMD", "AZN", "KZT", "UZS", "TJS", "TMT", "BYN", "MDL", "ALL", "MKD", "BAM", "EUR", "CHF", "GBP", "JPY", "AUD", "CAD", "CNY", "HKD", "IDR", "MYR", "NZD", "SGD", "THB", "VND", "BRL", "CLP", "MXN", "ARS", "COP", "PEN", "UYU", "EGP", "ILS", "SAR", "AED", "QAR", "KWD", "BHD", "OMR", "JOD", "LBP", "PKR", "PHP", "LKR", "NPR", "DKK", "NOK", "SEK", "CHF", "CZK", "HUF", "PLN", "RON", "HRK", "RSD", "BGN", "ISK", "GEL", "AMD", "AZN", "KZT", "UZS", "TJS", "TMT", "BYN", "MDL", "ALL", "MKD", "BAM", "EUR", "CHF", "GBP", "JPY", "AUD", "CAD", "CNY", "HKD", "IDR", "MYR", "NZD", "SGD", "THB", "VND", "BRL"};
	public static String convertTextFieldData = "";
	public static String convertFromComboBoxData = "USD";
	public static String convertToComboBoxData = "USD";
	public static String convertButtonData = "";
	public static String convertResultTextFieldData = "";
	public static String apiKeyTextFieldData = "";
	public static JTextField textFieldResult;

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
		textFieldInput.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				setTextFieldData(textFieldInput.getText());
			}

			@Override
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				setTextFieldData(textFieldInput.getText());
			}

			@Override
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
				System.out.println("changedUpdate");
			}
		});
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
		comboBoxFrom.addActionListener(e -> {
			System.out.println(comboBoxFrom.getSelectedItem());
			setComboBoxData("from", (String) comboBoxFrom.getSelectedItem());
		});
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
		comboBoxTo.addActionListener(e -> {
			System.out.println(comboBoxTo.getSelectedItem());
			setComboBoxData("to", (String) comboBoxTo.getSelectedItem());
		});
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
		
		textFieldResult = new JTextField("0.0", 6);
		textFieldResult.setBounds(0, HEIGHT / 4 + HEIGHT / 8, WIDTH, HEIGHT / 8);
		textFieldResult.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
		textFieldResult.setBackground(new Color(0, 255, 0));
		textFieldResult.setHorizontalAlignment(JTextField.CENTER);
		textFieldResult.setFont(textFieldResult.getFont().deriveFont(20.0f));
		textFieldResult.setForeground(new Color(0, 0, 0));
		textFieldResult.setEditable(false);
		resultPanel.add(textFieldResult);
		
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(0, 0, WIDTH, HEIGHT / 8);
        convertButton.setBorder(new javax.swing.border.LineBorder(new Color(0, 255, 0), 2, true));
        convertButton.setBackground(new Color(0, 255, 0));
        convertButton.setFont(new Font("Liberation Mono", Font.PLAIN, 20));
        convertButton.setForeground(new Color(0, 0, 0));
        convertButton.addActionListener(e -> {
        	buttonAction();
        });
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
		textFieldApiKey.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(javax.swing.event.DocumentEvent e) {
				System.out.println(textFieldApiKey.getText());
				apiKeyTextFieldData = textFieldApiKey.getText();
			}

			@Override
			public void removeUpdate(javax.swing.event.DocumentEvent e) {
				System.out.println(textFieldApiKey.getText());
				apiKeyTextFieldData = textFieldApiKey.getText();
			}

			@Override
			public void changedUpdate(javax.swing.event.DocumentEvent e) {
				System.out.println("changedUpdate");
			}
		});
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
	
	public static void createLatestCurrencyData() {
		String printer = "";
		try {
			File file = new File("latest_currency_data.json");
			if (file.createNewFile()) {
                printer = isDebug ? "File created: " + file.getName() : "";
            } else {
                printer = isDebug ? "File already exists." : "";
            }
		} catch (IOException e) {
			printer = isDebug ? "An error occurred." : "";
		}
		System.out.println(printer);
	}
	
	public static void writeLatestCurrencyData(String currencyData) {
		String printer = "";
		try {
			FileWriter fileWriter = new FileWriter("latest_currency_data.json");
			fileWriter.write(currencyData);
			fileWriter.close();
			printer = isDebug ? "Successfully wrote to the file." : "";
		} catch (IOException e) {
			printer = isDebug ? "An error occurred." : "";
		}
		System.out.println(printer);
	}
	
	public static void deleteLatestCurrencyData() {
		String printer = "";
		File file = new File("latest_currency_data.json");
		if (file.delete()) {
			printer = isDebug ? "Deleted the file: " + file.getName() : "";
		} else {
			printer = isDebug ? "Failed to delete the file" : "";
		}
		System.out.println(printer);
	}
	
	public static String readLatestCurrencyData() {
		String data = "";
		try {
			File file = new File("latest_currency_data.json");
			if (file.exists()) {
				System.out.println("File exists.");
			} else {
				System.out.println("File does not exist.");
				return "";
			}
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				data += scanner.nextLine();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("The data from the file: " + data);
		return data;
	}
	
	public static void setTextFieldData(String data) {
		if (isNumeric(data)) {
			convertTextFieldData = data;
		} else {
			System.out.println("Error: setTextFieldData");
		}
	}
	
	public static void setTextFieldData(String data, String fromTo) {
		if (isNumeric(data)) {
			if (fromTo.equals("result")) {
				convertResultTextFieldData = data;
			} else {
				System.out.println("Error: setTextFieldData");
			}
		} else {
			System.out.println("Error: setTextFieldData");
		}
	}
	
	public static void setTextFieldDataStr(String data) {
		convertTextFieldData = data;
	}
	
	public static void setComboBoxData(String fromTo, String data) {
		if (fromTo.equals("from")) {
			convertFromComboBoxData = data;
		} else if (fromTo.equals("to")) {
			convertToComboBoxData = data;
		} else {
			System.out.println("Error: setComboBoxData");
		}
	}
	
	public static void buttonAction() {
		Gson gson = new Gson();
		boolean fileExists = checkIfFileExists();
		boolean fileExistsAndIsValid = checkIfFileExistsAndIsValid();
		if (convertTextFieldData.equals("") || convertFromComboBoxData.equals("") || convertToComboBoxData.equals("")
				|| (!fileExists && apiKeyTextFieldData.equals("")) || (!fileExistsAndIsValid && apiKeyTextFieldData.equals(""))) {
			System.out.println("Error: buttonAction");
			return;
		} else {
			System.out.println("Success: buttonAction");
		}
		var client = HttpClient.newHttpClient();
		var request = HttpRequest.newBuilder(URI.create(
				"https://v6.exchangerate-api.com/v6/" + apiKeyTextFieldData + "/latest/" + convertFromComboBoxData))
				.header("accept", "application/json").build();
		try {
	        String responseData = readLatestCurrencyData();
	        boolean isData = false;
	        if (!responseData.isEmpty()) {
	            JsonObject rd = gson.fromJson(responseData, JsonObject.class);
	            JsonPrimitive time = rd.getAsJsonPrimitive("time_last_update_utc");
	            String timeString = time.getAsString();
	            String day = null;
	            try {
	                day = timeString.split(",")[0];
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            System.out.println("INFO:" + day);
	            System.out.println("INFO:" + getCurrentDay());
	            if (timeString != null && day != null && day.equals(getCurrentDay())) {
	                JsonObject conversionRates = rd.getAsJsonObject("conversion_rates");
	                double conversionRate = conversionRates.get(convertToComboBoxData).getAsDouble();
	                double convertedAmount = Double.parseDouble(convertTextFieldData) * conversionRate;
	                setTextFieldData(Double.toString(convertedAmount), "result");
	                textFieldResult.setText(Double.toString(convertedAmount));
	                isData = true;
	                return;
	            } else {
	            	isData = false;
	            }
	       }
	       if (!isData) {
				var response = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
				JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
				JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
				double conversionRate = conversionRates.get(convertToComboBoxData).getAsDouble();
				double convertedAmount = Double.parseDouble(convertTextFieldData) * conversionRate;
				setTextFieldData(Double.toString(convertedAmount), "result");
				textFieldResult.setText(convertResultTextFieldData);
				writeLatestCurrencyData(response.body());
	        }
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkIfFileExists() {
		File file = new File("latest_currency_data.json");
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean checkIfFileExistsAndIsValid() {
		String data = readLatestCurrencyData();
		if (data.isEmpty()) {
			return false;
		}
		try {
			Gson gson = new Gson();
            JsonObject rd = gson.fromJson(data, JsonObject.class);
            JsonPrimitive time = rd.getAsJsonPrimitive("time_last_update_utc");
            String timeString = time.getAsString();
            String day = null;
            try {
                day = timeString.split(",")[0];
            } catch (Exception e) {
                e.printStackTrace();
            }
			if (timeString != null && day != null && day.equals(getCurrentDay())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}	
	}
	
	public static String getCurrentDay() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE", Locale.ENGLISH);
		String day = simpleDateFormat.format(date.getTime());
		return day;
	}
	
	public static boolean isNumeric(String str) { 
	  try {  
	    Double.parseDouble(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
	
}
