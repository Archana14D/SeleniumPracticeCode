package seleniumSessions;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day24_01WaitForAlert {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click(); //Here, if we do not click on proceed button, we will not get any alert, so it will give TimeOutException after 10 sec

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert =  wait.until(ExpectedConditions.alertIsPresent());   //It will automatically switch to the alert
		
		String text = alert.getText();
		System.out.println(text);

		alert.accept();
	}	

	public static Alert waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.alertIsPresent());   //It will automatically switch to the alert
	}

	public static String getAlertText() {
		return waitForAlert().getText();
	}
	
	public static void aceptAlert() {
		waitForAlert().accept();
	}
	
	public static void dismissAlert() {
		waitForAlert().dismiss();
	}
	
	public static void alertSendKeys(String value) {
		waitForAlert().sendKeys(value);
	}
}
