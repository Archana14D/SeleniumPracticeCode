package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day04_02LaunchFirefox {

	public static void main(String[] args) {
		// geckodriver.exe ---> mozilla

		System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJavaProjects\\geckodriver\\geckodriver.exe");
		// WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new FirefoxDriver(); // mentioned in setProperty
		WebDriver driver1 = new ChromeDriver(); // mentioned WDM
 
		driver.get("https://www.google.com");
		driver.getTitle();
		driver.close();
	}
}
