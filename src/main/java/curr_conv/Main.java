package curr_conv;

import java.awt.Color;

public class Main {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	static final String TITLE = "Currency Converter";
	public static void main(String[] args) {
		try {
			new CurrencyConverterFrame(WIDTH, HEIGHT, TITLE, "src/main/java/assets/curr_64.png", new Color(15, 15, 20));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
