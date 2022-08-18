package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day17_04AuthPopup {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//after entering username and password only we are allowed to proceed further.
		//it should be in the form:
		//https://username:password@domain
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		//limitations:
		//username and password must be correct
		//password should not include @ symbol
		
		
		String username = "admin";
		String password = "admin";
		driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		
		
		
	}
}
