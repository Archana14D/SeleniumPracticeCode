package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day15_01DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//Drag and drop is possible from element to element only, not anywhere else like drive to drive
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		//act.clickAndHold(sourceEle).moveToElement(targetEle).release().build().perform();
		//build(): collect all the actions to perform and supply to perform() method
		//perform(): perform all the actions in a sequence
		
		
		//or we can use below method:
		act.dragAndDrop(sourceEle, targetEle).perform();
}
}