package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day12_03WebTableCheckbox {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		//driver.findElement(By.xpath("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
		//		.click();
		
		//selectUserName("Garry.White");
		//selectUserName("Jasmine.Morgan");
		
		//If we want to click on all checkboxes in a column
//		List<WebElement> CheckBoxList = driver.findElements(By.xpath("//input[@type='checkbox' and @name='chkSelectRow[]']"));
//		for(WebElement e: CheckBoxList) {
//			e.click();
//		}
	}
	
		public static void selectUserName(String Username) {
			driver.findElement(By.xpath("//a[text()='"+Username+"']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		}
}
