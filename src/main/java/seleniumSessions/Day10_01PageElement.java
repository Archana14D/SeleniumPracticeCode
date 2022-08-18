package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day10_01PageElement {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");

//		// driver.findElement(By.name("search11")).sendKeys("macbook");
//
//		// Using findElement(), if we are writing wrong locator in findElement() method,
//		// we will get NoSuchElementException
//		// though we are using, name, id or any locator to find any webElement,
//		// internally, Selenium is using CSS selector
//		// In Selenium, there is no ElementNotFoundException concept
//
//		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
//		List<WebElement> leftLinks = driver.findElements(By.xpath("//aside[@id='column-right11']//a"));
//		// when we are writing wrong locator with findElements(), we do not get any
//		// excecption,
//		// instead we get an empty list
//		System.out.println(leftLinks.size());
//
//		List<WebElement> searchList = driver.findElements(By.name("search"));
//		if (searchList.size() == 1) {
//			System.out.println("Search is present on the page");
//		}
//
//		boolean flag = driver.findElement(By.name("search")).isDisplayed(); // If a webElement is present on the
//																			// webpage, does not matter enabled or
//																			// disabled, it returns true
//		System.out.println(flag);
//		if (flag) {
//			System.out.println("Search is present on the page");
//		}

		By search = By.name("search");
//		if (checkSingleElementExist(search)) {
//			System.out.println("search exists only for one time on page");
//		}
//
//		By forgotPwd = By.linkText("Forgotten Password");
//		if (checkElementMultipleExist(forgotPwd)) {
//			System.out.println("Search exists for more then one");
//			if (getElementCount(forgotPwd) == 2) {
//				System.out.println("forgot password link coming for 2 times on a page");
//			}
//		}

		getElement(search).sendKeys("macbook");
		driver.navigate().refresh();
		getElement(search).sendKeys("samsung");
		
		
		//If we are writing wrong syntax of xpath or any locator, while finding an element, selenium gives
		//InvalidSelectorException i.e.syntax is wrong here
		//driver.findElement(By.xpath("//input[@@#@id = 'input-html']")).sendKeys("archana@gmail.com");
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static boolean doIsDispalyed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static int getElementCount(By locator) {
		int eleCount = getElements(locator).size();
		return eleCount;
	}

	public static boolean checkSingleElementExist(By locator) {
		if (getElementCount(locator) == 1) {
			return true;
		}
		return false;
	}

	public static boolean checkElementMultipleExist(By locator) {
		if (getElementCount(locator) > 1) {
			return true;
		}
		return false;
	}

}
