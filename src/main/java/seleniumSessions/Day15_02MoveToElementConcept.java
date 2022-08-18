package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day15_02MoveToElementConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Drag and drop is possible from element to element only, not anywhere else
		// like drive to drive
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com");
		
//		WebElement parentMenu = driver.findElement(By.className("menulink"));
//
//		Actions act = new Actions(driver);
//		act.moveToElement(parentMenu).perform();
//		 If we do not write .build() and .perform() in any act related statements, we
//		 will get NoSuchElementException. This is because, the action is not get
//		 performed and hence the elements in further script are not found or available
//
//		Thread.sleep(2000);
//		driver.findElement(By.linkText("COURSES")).click();

		By parentMenu = By.className("menulink");
		By courses = By.linkText("COURSES");
		By singleVideos= By.linkText("SINGLE VIDEOS");
			
		handleTwoLevelMenuItems(parentMenu, courses);
		driver.navigate().back();
		handleTwoLevelMenuItems(parentMenu, singleVideos);
		
	}
	public static void handleTwoLevelMenuItems(By parentMenu, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
}
