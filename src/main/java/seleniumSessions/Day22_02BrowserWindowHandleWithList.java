package seleniumSessions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day22_02BrowserWindowHandleWithList {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.cssSelector("img[alt='OrangeHRM on twitter']")).click();

		Set<String> handles = driver.getWindowHandles();
		// Set to List
		List<String> handlesList = new ArrayList<String>(handles);

		String parentWindowId = handlesList.get(0);
		String childWindowId = handlesList.get(1);

		driver.switchTo().window(childWindowId);
		System.out.println("Child window url: " + driver.getCurrentUrl());

		driver.close();

		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window url: " + driver.getCurrentUrl());
		System.out.println("Parent window title: " + driver.getTitle());

		driver.quit();

	}
}
