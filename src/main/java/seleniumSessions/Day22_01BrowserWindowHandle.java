package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day22_01BrowserWindowHandle {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.cssSelector("img[alt='OrangeHRM on twitter']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		String parentWindowId = it.next();
		System.out.println("Parent window id: "+parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("Child window id: "+childWindowId);
		
		driver.switchTo().window(childWindowId);
		System.out.println("Child window url: "+driver.getCurrentUrl());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window url: "+driver.getCurrentUrl());
		System.out.println("Parent window title: "+driver.getTitle());
		
		driver.quit();
		
	}
}
