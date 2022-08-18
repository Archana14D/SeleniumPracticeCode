package seleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day22_03BrowserWindowHandleOneeByOne {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.cssSelector("img[alt='LinkedIn OrangeHRM group']")).click();
		Set<String> handles1 = driver.getWindowHandles();

		Iterator<String> it1 = handles1.iterator();

		String parentWindowId = it1.next();
		String childWindowId = it1.next();

		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());

		// 2.
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on Facebook']")).click();
		Thread.sleep(2000);

		Set<String> handles2 = driver.getWindowHandles();

		Iterator<String> it2 = handles2.iterator();
		parentWindowId = it2.next();
		childWindowId = it2.next();

		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.close();
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());

		// 3.
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on twitter']")).click();
		Thread.sleep(2000);

		Set<String> handles3 = driver.getWindowHandles();

		Iterator<String> it3 = handles3.iterator();
		parentWindowId = it3.next();
		childWindowId = it3.next();

		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.close();
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());

		// 4.
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on youtube']")).click();
		Thread.sleep(2000);

		Set<String> handles4 = driver.getWindowHandles();

		Iterator<String> it4 = handles4.iterator();
		parentWindowId = it4.next();
		childWindowId = it4.next();

		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.close();
		driver.switchTo().window(parentWindowId);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());

	}
}
