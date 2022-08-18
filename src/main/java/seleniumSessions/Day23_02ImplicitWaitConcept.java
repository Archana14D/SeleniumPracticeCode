package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day23_02ImplicitWaitConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//three types:
				//1. static wait: Thread.sleep(10000) - Java Lib
				//2. dynamic waits: Selenium Lib
						//2.a: Implicitly Wait
						//2.b: Explicit Wait
								//2.b.1: WebDriverWait
								//2.b.2: FluentWait
				
		// Static wait: Thread.sleep();
		// Dynamic wait:
		// implicitly wait: global wait: will be applied to all elements on the page
		// Only applicable for webElements
		// Not applicable for non-WebElements: alerts, url, title

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");

		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //deprecated
		// from selenium 3

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // selenium 4
		// Implicitly wait is applied to all the webElements we try to interact using driver.
		// If the element is available in 2 seconds, rest 8 seconds are ignored. If
		// element is not found after 10 seconds as well, then it thorws an exception:
		// NoSuchElementException


		WebElement mac = driver.findElement(By.linkText("MacBook")); // we have applied implicit wait on driver. So
																	// whenever we are creating a webElement using
																	// driver, it will check for the wait, and won't
																	// throw exception if element not found, it will
																	// wait for the timeout

		mac.click();

		// Problem with the implicit wait is that, it's a global wait and by default it
		// is applied on each and every webElement.
		// It means if we go on each page, each webElement we try to interact, the
		// timeout in wait is applied to it
		// Though the element is available on a webpage, it has to go through the wait
		// logic, so unnecessarily wait is running in the background
		// So here in implicit wait we are not freedom of using implicitly wait for a
		// specific webElement

		// Second issue is that, we need to override(update) timeout, according to the requirement
		// e.g.On home page we are having wait with 10 sec. So same will be applied to all
		// next redirected pages.
		// Now, if in case, we do not need 10 seconds to wait, we have to update the
		// time period to smaller one. Now, this will be applicable to all next
		// redirected pages. Again if we need larger time period, we need to update like that.		
		
		//Third issue is that
		//It is applicable only for webElements
		// Not applicable for non-WebElements: alerts, url, title

		//Hence, we should not use implicitly wait

		//2nd page: 10 secs
		//e2 
		//e3
		//e4 - click
		//logout ---> Login Page
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//sel 4.x

		//3rd page: 20 secs 
		//e5 e6 e7 - click
		
		//home page: 10
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//sel 4.x

		//register page: 5
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//sel 4.x

		//home page: 5
		
		//forgotpwd : 0 --nullify imp wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));//sel 4.x
		
		
		
		
		
		
	
	
	}
}
