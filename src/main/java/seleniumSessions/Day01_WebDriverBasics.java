package seleniumSessions;

/*17: selenium
3: testNG
9:framework
3:git
1:jenkin
2:docker
*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_WebDriverBasics {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJavaProjects\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.get("https://www.google.com"); // enter url. Here, if we remove, https here, it gives
												// InvalidArguementException
		// www is not mandatory
		// return type of get method is void

		String title = driver.getTitle(); // get the title ; return type of getTitle() method is String
		System.out.println("Page title is:" + title);

		// verification point / checkpoint / assertion / actual v/s expected value
		if (title.equals("Google")) {
			System.out.println("Correct title");
		} else {
			System.out.println("Incorrect title");
		}

		String url = driver.getCurrentUrl();
		System.out.println(url);

		String source = driver.getPageSource();
		System.out.println(source.contains(" Copyright The Closure Library Authors"));

		driver.quit(); // closes the browser which is opened by the selenium
	}
}