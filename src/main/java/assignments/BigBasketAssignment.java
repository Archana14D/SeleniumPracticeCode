package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasketAssignment {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(5000);
		
//		WebElement mainCat = driver.findElement(By.cssSelector("a.meganav-shop"));
//		Actions act = new Actions(driver);
//		
//		act.moveToElement(mainCat).perform();
//		Thread.sleep(2000);
//		
		List<WebElement> l1 =driver.findElements(By.cssSelector("a.meganav-shop")); 
				//driver.findElements(By.id("navBarMegaNav"));
		Thread.sleep(2000);
		System.out.println(l1.size());
		
	}
}
