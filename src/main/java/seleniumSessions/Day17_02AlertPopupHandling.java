package seleniumSessions;

import java.net.MalformedURLException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day17_02AlertPopupHandling {

	// there are 3 types of JavaScript popups (modal dialog popup)
	// 1.alert('')
	// 2.prompt('')
	// 3.confirm('')

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();

		Alert alert = driver.switchTo().alert(); /// it returns an alert reference
		String text = alert.getText();
		System.out.println(text);

		Thread.sleep(2000);
		alert.accept();

		//alert.dismiss(); // If we use alert methods when there are no alert popup on a page, it gives
							// NoAlertPresentException i.e.no such alert

		//alert.sendKeys("testing");
	}
}
