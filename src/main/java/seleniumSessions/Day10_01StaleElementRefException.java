package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day10_01StaleElementRefException {

	// Every time we refresh the page, DOM gets refreshed, so the WebElements that
	// are created before refreshing the web page gets expired (webelement id gets expired), and we get
	// StaleElementReferenceException
	//It happens in case of back and forward the page as well, as DOM gets refreshed.

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("archana@test.com");

		driver.navigate().refresh();

		email.sendKeys("test@test.com"); // StaleElementReferenceException

//		first solution for this is, we can create a webelement once again

		email = driver.findElement(By.id("input-email"));
		email.sendKeys("archana@test.com");

		// second approach is, we can use By locator. Using By locator, it just creates
		// By locator, but does not hit the server, so there is no webElement id that
		// gets created.

		By search = By.name("search");

		getElement(search).sendKeys("macbook");
Thread.sleep(2000);
		driver.navigate().refresh();
		getElement(search).sendKeys("samsung");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}