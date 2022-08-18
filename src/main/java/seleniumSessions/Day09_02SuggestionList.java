package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day09_02SuggestionList {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		
		Thread.sleep(3000);
		
		//selectItem("T-shirts > Faded Short Sleeve T-shirts");
	}

//	public static void selectItem(String productName) {
//		driver.findElement(By.xpath("//li[text()='"+productName+"']")).click();
//		
	}
	
