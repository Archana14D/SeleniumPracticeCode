package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day23_03ExplicitWaitConcept {

	// 2.b: Explicit Wait: dynamic wait
		// 2.b.1: WebDriverWait
		// 2.b.2: FluentWait

	// It is applied for a specific web element only, not a global wait
	// can be applied for non web elements: alerts, url, title

	// WebDriverWait(class) --> extends --> FluentWait(class) --> implements --> Wait(I)
	// until(){}; method is present in Wait(I) which is implemented in FluentWait(C)
	// along with other methods
	// WebDriverWait(class) can access parent class(FluentWait) methods
	// WebDriverWait(class) does not have its own methods

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");

		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");

		//We do not need to write driver.findElement(). because until() method takes care of it
		// return type of until() method is T, which means it changes accordingly, which
		// must not be void

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // sel 4.x
		WebElement email_ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailId)); //ExpectedConditions is a class
		email_ele.sendKeys("archana@gmail.com");

		driver.findElement(password).sendKeys("Test@123");

		WebElement logon_ele = wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));
		logon_ele.click();

//		Here, we are using explicit wait only for 2 webElements
// If element is not found, we will get TimeoutException and NoSuchElementException	

//		doSendKeysWithWait(emailId, 5, "tom@gmail.com");
//		doSendKeys(password, "test@123");
//		doClick(loginBtn);
		
		//visibility of the element: 
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement email_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
//		email_ele.sendKeys("test@gmail.com");
		
	
	}
	
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeysWithWait(By locator, int timeOut, String value) {
		waitForElementVisible(locator, timeOut).sendKeys(value);
	}
	
	public static void doClickWithWait(By locator, int timeOut) {
		waitForElementVisible(locator, timeOut).click();
	}
	
	/**
	 *  presenceOfElementLocated():
	 *  An expectation for checking that an element is present on the DOM of a page. 
	 *  This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible. 
	 * Visibility means that the element is not only displayed 
	 * but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	
	
	

}
