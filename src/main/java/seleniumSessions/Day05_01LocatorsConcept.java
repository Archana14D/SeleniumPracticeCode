package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day05_01LocatorsConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// webElement + actions (click,sendKeys, getText,isDisplayed...)

		// 1.id

		// 1st approach:
		// say e.g, we have 10 text fields, we will have to write same code again and
		// again
//		driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");  //to enter a text. sendKeya method always returns String value 
//		driver.findElement(By.id("input-password")).sendKeys("test@123");  //By is a class and id() is the static method to get id of a webElement
//		

		// 2nd : In this approach, I can create all the web elements, and can use as per
		// requirement. I can re-use the variables whenever required.
		// But hitting request to server using findElement() for every webElement

//		WebElement emailId = driver.findElement(By.id("input-email")); //findElement() is a method to interact with a single element. findElement() method returns a WebElement. webElement is an interface which is extended from SearchContext interface.
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("naveen@gmail.com");
//		password.sendKeys("test@123");
//		
		// 3rd: By locator: It is Object Repository : In this approach, we are creating
		// By locators
		// for all webElements, but hitting to server using findElement() only when it
		// is required.

		// creating a By element
//		By emailId = By.id("input-email"); // id() is a static method available in the By class; the return type of this method is By, so we are storing the value in a By reference
//		By password = By.id("input-password");
//
//		// creating a webElement
//		WebElement emailEle = driver.findElement(emailId);
//		WebElement passwordEle = driver.findElement(password);
//
//		// performing action
//		emailEle.sendKeys("naveen@gmail.com");
//		passwordEle.sendKeys("test@123");

		// 4. By locator + generic function : We are hitting the server only once here
		// in a generic function getElement()

//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		getElement(emailId).sendKeys("naveen@gmail.com");
//		getElement(password).sendKeys("test@123");

		// 5. By Locator + generic function for element and actions:
		// 4th and 5th approaches are almost same, here, we are creating a generic
		// method for sendKeys as well
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//	
//		doSendKeys(emailId, "naveen@gmail.com");
//		doSendKeys(password, "test@123");

		// 6.By Locator + generic function for element and actions in some util class
		// This approach is a generic utility which can be used for any application

//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//
//		Day05_02ElementUtil eleUtil = new Day05_02ElementUtil(driver);
//		eleUtil.doSendKeys(emailId, "naveen@gmail.com");
//		eleUtil.doSendKeys(password,"test@123");

		// 7. combining BrowserUtil and ElementUtil in a single class :
		// LoginPageTest.java

		// 8.String Locator + generic function for element and actions in some util
		// class
		String email_id = "input-email";
		String password_id = "input-password";

		// By email = By.id(email_id);
		// By password = By.id(password_id);

		// doSendKeys(email, "test@gmail.com");
		// doSendKeys(password, "test@123");

		// doSendKeys("id", email_id, "test@gmail.com");
		// doSendKeys("id", password_id, "test@123");

	}

	public static By getBy(String locatorType, String selector) {

		By locator = null;

		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(selector);
			break;
		case "name":
			locator = By.name(selector);
			break;
		case "class":
			locator = By.className(selector);
			break;
		case "xpath":
			locator = By.xpath(selector);
			break;
		case "cssselector":
			locator = By.cssSelector(selector);
			break;
		case "linktext":
			locator = By.linkText(selector);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(selector);
			break;
		case "tagname":
			locator = By.tagName(selector);
			break;

		default:
			break;
		}

		return locator;

	}

	public static void doSendKeys(String locatorType, String selector, String value) {
		By locator = getBy(locatorType, selector);
		getElement(locator).sendKeys(value);
	}

	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator); // return is must here, else sendKeys() method will not work
	}
}
