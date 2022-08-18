package myTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day02_04GoogleTest extends Day02_06BaseTest {
	@Test(priority = 1)
	public void titleTest() {
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
	}

	@Test(priority = 2)
	public void searchFieldTest() {
		Assert.assertTrue(driver.findElement(By.name("q")).isDisplayed());
	}
}
