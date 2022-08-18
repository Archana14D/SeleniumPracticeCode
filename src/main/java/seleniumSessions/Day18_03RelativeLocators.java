package seleniumSessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day18_03RelativeLocators {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.aqi.in/dashboard/canada");
		WebElement baseEle = driver.findElement(By.linkText("Sorel-Tracy, Canada"));
		
		//driver.findElement(RelativeLocator.with(by))
		String rightIndex = driver.findElement(with(By.tagName("p")).toRightOf(baseEle)).getText();
		System.out.println(rightIndex);
		
		String leftRank = driver.findElement(with(By.tagName("p")).toLeftOf(baseEle)).getText();
		System.out.println(leftRank);
		
		
		String belowCity = driver.findElement(with(By.tagName("p")).below(baseEle)).getText();
		System.out.println(belowCity);
		
		String aboveCity = driver.findElement(with(By.tagName("p")).above(baseEle)).getText();
		System.out.println(aboveCity);
		
		String nearCity = driver.findElement(with(By.tagName("p")).near(baseEle)).getText();
		System.out.println(nearCity);
		
		List<WebElement> belowEles = driver.findElements(with(By.tagName("p")).below(baseEle));
		System.out.println(belowEles.size());
		for(WebElement e : belowEles) {
			System.out.println(e.getText());
		}
	
		//try to avoid using relative locators with finElements(), because it gives all elements
		
	
	}
}
