package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day14_01ClassConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://app.hubspot.com/login?hubs_signup-url=www.hubspot.com/&hubs_signup-cta=homepage-nav-login");
		
		//If there are multiple space separated class names, we get such exception
		//InvalidSelectorException - Compound class names not permitted
		//driver.findElement(By.className("form-control private-form__control login-email")).sendKeys("archana@gmail.com");
		
		//instead we can use single class name
		//driver.findElement(By.className("login-email")).sendKeys("archana@gmail.com");		
		
		//or we can use xpath
		//driver.findElement(By.xpath("//input[@class='form-control private-form__control login-email']")).sendKeys("archana@gmail.com");

		//or we can use cssSelector
		//driver.findElement(By.cssSelector(".form-control.private-form__control.login-email")).sendKeys("archana@gmail.com");
		driver.findElement(By.cssSelector("input.login-email")).sendKeys("archana@gmail.com");

		
}
}