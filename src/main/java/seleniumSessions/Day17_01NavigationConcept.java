package seleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day17_01NavigationConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		// to() is a method from Navigation interface which is implemented in 
		// (private) RemoteNavigation class, that internally uses get() method
		
		//There is no such difference between get() and navigate() method. Both will work when page is get fully loaded 
		//The only difference between get() and navigate().to() is that to() method can
		// take a URL or a string as an argument. But get90 method can take only string
		// as an argument
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.navigate().forward();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.navigate().back();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		
		driver.navigate().to(new URL("https://www.amazon.com")); // here , we have to pass url in the form of URL object
		driver.navigate().refresh(); //to refresh the webpage
	}
}
