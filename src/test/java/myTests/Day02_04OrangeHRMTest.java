package myTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day02_04OrangeHRMTest extends Day02_06BaseTest {

	@Test(priority = 1)
	public void titleTest() {
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "30-Day Advanced Free Trial | OrangeHRM");
	}

	@Test(priority = 2)
	public void contactSalesLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("OrangeHRM")).isDisplayed());
	}
}
