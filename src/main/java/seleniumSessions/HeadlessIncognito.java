package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessIncognito {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		//headless:
		//no browser is displayed
		//testing is fast
		
		
		ChromeOptions co=new ChromeOptions();
		//co.addArguments("--headless");
		//co.setHeadless(true);
		
		co.addArguments("--incognito"); //does not maintain browser history
		
		//WebDriver driver = new HtmlUnitDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();
	}

}
