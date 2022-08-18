package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day09_03LanguageLinks {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		//OPtion 1
		String text1 = driver.findElement(By.id("SIvCob")).getText();
		// when we apply getText() method on any element, it gives text of specified
		// element along with
		// its child elements
		System.out.println(text1);
		
		//OPtion2
		List<WebElement> langLinks = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		System.out.println(langLinks.size());
		
		for(WebElement e: langLinks) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains("मराठी")) {
				e.click();
				break;
			}
		}
	}
}