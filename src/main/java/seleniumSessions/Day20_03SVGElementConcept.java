package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day20_03SVGElementConcept {

	// for SVG, normal xpath does not work, we have to use specialized xpath, also,
	// css does not support

//	//*[local-name()='svg']/*[name()='g']
//	//*[local-name()='svg']/*[name()='g' and @fill-rule='evenodd']
//  //*[name()='g' and @fill-rule='evenodd']	

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://petdiseasealerts.org/forecast-map#/");

		Thread.sleep(2000);
		List<WebElement> stateList = driver.findElements(By
				.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='path']"));

		System.out.println(stateList.size());
		Actions act = new Actions(driver);

		for (WebElement e : stateList) {
			String name = e.getAttribute("name");
			System.out.println(name);
			if (name.equals("California")) {
				//e.click();
				act.click(e).perform();
				break;
			}
		}

	}
}
