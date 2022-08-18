package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day23_01SignatureActions {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://signature-generator.com/draw-signature/");

		//Action interface gives all the composite actions together
		//With the help of Actions class, we have to perform those actions 

		WebElement canvas = driver.findElement(By.id("signature-pad"));
		Actions act = new Actions(driver);   //Actions is a class
		Action signature = act.click(canvas)  //Action is an interface 
				.moveToElement(canvas, 3, 3)
				.clickAndHold(canvas)
				.moveToElement(canvas, -200, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -50)
				.moveByOffset(50, -50)  // If we unnecessarily go beyond the canvas limit, it gives an exception as MoveTargetOutOfBoundsException
				.moveByOffset(3,3)
				.release()
				.build();                  //return type of a build() method is Action,which is a composite action
		signature.perform();
	}

}
