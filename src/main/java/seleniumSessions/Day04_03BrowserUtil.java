package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day04_03BrowserUtil {

	// Use of this BrowserUtil approach is we can use it for any application

	private WebDriver driver; // here, driver is a reference variable (non-primitive data type), so it's
								// default value is null
	// If it is public, then this can be accessible to anyone who is creating object
	// of the class, and then will get a null value (NPE)

	/**
	 * This method is used to initialize the driver on the basis of given browser
	 * name 
	 * @param browserName
	 * @return this returns driver
	 */

	public WebDriver initDriver(String browserName) {
		System.out.println("browser name is: " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver(); // Safari does not need any .exe
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Please pass the right browser.. " + browserName);
		}
		return driver;
	}

	/**
	 * this method is used to launch the url
	 * 
	 * @param url
	 */
	public void launchUrl(String url) {
		if (url == null) {
			System.out.println("URL is null");
			return;
		} else if (url.indexOf("https") == -1) {
			System.out.println("url is not having https");
			return;
		} else if (url.indexOf("http") == -1) {
			System.out.println("url is not having http");
			return;
		} else if (url.length() == 0) {  
			System.out.println("please enter a url");
			return;
		}

		driver.get(url);
	}

	/**
	 * this method is used to return the page title
	 * 
	 * @return
	 */
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		return title;
	}

	public String getPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Page url is: " + url);
		return url;
	}

	// url fraction = partial part of complete url

	public boolean isUrlFractionExist(String urlFraction) {
		if (getPageSource().contains(urlFraction)) {
			return true;
		}
		return false;
	}

	public String getPageSource() {
		String source = driver.getPageSource();
//		System.out.println("Page source is: "+source);
		return source;
	}

	public boolean isInfoExistInPageSource(String info) {
		if (getPageSource().contains(info)) {
			return true;
		}
		return false;
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
