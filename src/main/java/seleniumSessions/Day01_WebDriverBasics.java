package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day01_WebDriverBasics {

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver",
		// "D:\\SeleniumJavaProjects\\chromedriver\\chrome.exe");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();// launch chrome
		driver.get("https://www.google.com");// enter url

		
		String title = driver.getTitle();//get the title
		System.out.println("page title is: " + title);
		
		//verification point/checkpoint/assertion/act vs exp result
		if(title.equals("Google")) { System.out.println("correct title"); } else {
		System.out.println("incorrect title"); }
		
		//automation steps + verification point(checkpoint) => Automation Testing
		
		String url = driver.getCurrentUrl(); System.out.println(url);
		
		String source = driver.getPageSource(); //
		System.out.println(source.contains("Copyright The Closure Library Authors"));
		
		//driver.quit();//close the browser
	
	}
}