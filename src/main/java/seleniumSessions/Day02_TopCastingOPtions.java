package seleniumSessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Day02_TopCastingOPtions {
	public static void main(String[] args) {

		//1.cross-browser testing
		WebDriver driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver = new SafariDriver();
		
		//2.Specific browser
		ChromeDriver driver1 = new ChromeDriver();
		FirefoxDriver driver2 = new FirefoxDriver();
		SafariDriver driver3 =  new SafariDriver();
		
		//3.RWD --> CD
		RemoteWebDriver d1 = new ChromeDriver();
		d1.get("https://www.google.com");
		
		//4.WD --> RWD
		//remote execution: grid, cloud, aws, docker grid
		//WebDriver d2 = new RemoteWebDriver(remoteAddress, capabilities);
		
		//5.SC --> CD //not recommended
		SearchContext d3 = new ChromeDriver();
		// this is a valid topcasting, but we have only 2 methods to access, FE and FEs
	}
}
