package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Day05_03LoginPageTest {

	public static void main(String[] args) {

		Day04_03BrowserUtil brUtil = new Day04_03BrowserUtil();
		WebDriver driver = brUtil.initDriver("chrome");
		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(brUtil.getPageTitle());
		System.out.println(brUtil.getPageUrl());

		By emailId = By.id("input-email");
		By password = By.id("input-password");

		Day05_02ElementUtil eleUtil = new Day05_02ElementUtil(driver);
		eleUtil.doSendKeys(emailId, "naveen@gmail.com");
		eleUtil.doSendKeys(password, "test@123");

		// brUtil.closeBrowser();

	}

}
