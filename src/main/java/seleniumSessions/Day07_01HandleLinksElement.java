package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day07_01HandleLinksElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException   {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		//driver.findElement(By.linkText("https://naveenautomationlabs.com/opencart/"));
		
		//6. link text:
		//driver.findElement(By.linkText("MacBook")).click();
		//link html tag = <a> with text
//		By macLink = By.linkText("MacBook");
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doClick(macLink);
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		Thread.sleep(5000);
		//driver.findElement(By.linkText("CONTACT SALES")).click();  //Whatever the text of link is displayed on UI should be consider instead of taking it from DOM. Sometimes, whatever is given in DOM is not same as that on UI, so we should consider what text is displayed on UI 
		
//		String contactsales_text = "CONTACT SALES";
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doClick("linktext", contactsales_text);
		
		//7. partial link text:
		//CONTACT SALES
		//CONTACT TEAM
		//CONTACT Marketing
		driver.findElement(By.partialLinkText("SALES")).click();  //for safer side, text given in partialLinkText() should be unique
	}

}
