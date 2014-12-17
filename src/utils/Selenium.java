package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {
	private Selenium() {
		throw new AssertionError();
	}

//  private static WebDriver driver = new HtmlUnitDriver();
	private static WebDriver driver = new FirefoxDriver();
	
	public static WebDriver getDriver() {
		return driver;
	}
	public static void goTo(String url) {
		driver.get(url);
	}
}
