package currency_converter;

import java.awt.Color;

public class Main {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	static final String TITLE = "Currency Converter";
	public static void main(String[] args) {
		CurrencyConverterFrame frame = new CurrencyConverterFrame(WIDTH, HEIGHT, TITLE, "src/assets/curr_64.png", new Color(15, 170, 255));
	}
}
