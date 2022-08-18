package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day12_02XpathAxes {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/india-in-ireland-2022-1303299/ireland-vs-india-2nd-t20i-1303308/full-scorecard");

		// ***********Xpath Axes***/
		// *******************Parent to child:
		// select[@id='Form_submitForm_Country']/option
		// select[@id='Form_submitForm_Country']/child::option
		// input[@id='username']

		// *******************Child to parent:

		// backward traversing:
		// input[@id='username']/../../../../../..
		// input[@id='username']/parent::div :using this approach we can go to the
		// immediate parent only, we can't go to grandparent and so on. for that we can
		// use /ancestor

		// *******************Child to ancestor
		// input[@id='username']/ancestor::form

		System.out.println(getWicketTakerName("Deepak Hooda"));
		System.out.println(getWicketTakerName("Hardik Pandya"));
		System.out.println(getWicketTakerName("Dinesh Karthik"));

		System.out.println(getPlayerScoreCardList("Deepak Hooda"));
		System.out.println(getPlayerScoreCardList("Hardik Pandya"));
		System.out.println(getPlayerScoreCardList("Dinesh Karthik"));
		
	}

	// Find out wicket taker from score card

	public static String getWicketTakerName(String playerName) {
		String wicketTaker = driver
				.findElement(By.xpath("//span[text()='" + playerName + "']/ancestor::td/following-sibling::td"))
				.getText();
		return wicketTaker;
	}

	// find out score card of a player

	public static List<String> getPlayerScoreCardList(String playerName) {
		List<WebElement> scoreList = driver
				.findElements(By.xpath("//span[text()='" + playerName + "']/ancestor::td/following-sibling::td"));
		List<String> scoreCardList = new ArrayList<>();
		for(WebElement e: scoreList) {
			String text = e.getText();
			scoreCardList.add(text);
		}
		return scoreCardList;
		
	}

}
