package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetMouseMovement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Drag and drop is possible from element to element only, not anywhere else
		// like drive to drive
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(4000);
		//driver.switchTo().alert().dismiss();
		//Thread.sleep(2000);
		WebElement SpiceClub = driver.findElement(By.xpath("https://www.spicejet.com/"));
		Actions act = new Actions(driver);
		act.moveToElement(SpiceClub);
				
	}
}