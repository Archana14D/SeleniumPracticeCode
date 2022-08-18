package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day08_01TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		List<WebElement> linksList = driver.findElements(By.tagName("a")); // there is no sendKeys() or click() method
																			// for findElements() as there are multiple
																			// elements that we get
																			// It gives a list of WebElements
		System.out.println("Total links: " + linksList.size());

//		for (int i = 0; i < linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//			if (text.length() != 0) { // we can write like : if(!text.isEmpty())
//				System.out.println(i + " : " + text);
//			}
//		}
//
//		int count = 0;
//		for (WebElement e : linksList) {
//			String text = e.getText();
//			if (!text.isEmpty()) {
//				System.out.println(count + " : " + text);
//			}
//			count++;
//		}

		By links = By.tagName("a");
		By images = By.tagName("img");
		By links_xpath = By.xpath("//a[@href]");

		int totalLinks = getPageElementsCount(links);
		System.out.println("Page Links:" + totalLinks);

		int totalimages = getPageElementsCount(images);
		System.out.println("Page Images:" + totalimages);

		int totalLinksUsingXpath = getPageElementsCount(links_xpath);
		System.out.println("Page Links using xpath:" + totalLinksUsingXpath);

		List<String> linksTextList = getElementsTextList(links);
		System.out.println(linksTextList);

		if (linksTextList.contains("Careers")) {
			System.out.println("PASS");
		}

		System.out.println("non blank list: " + getPageElementsCount(links));
	}

	//======================================================================
	
	public static int getEmptyEleTextList(By locator) {
		int totalLinks = getPageElementsCount(locator);
		int totalNonEmptyLinks = getElementsTextCount(locator);
		return totalLinks - totalNonEmptyLinks;
	}
	
	// non blank list counter
	public static int getElementsTextCount(By locator) {
		return getElementsTextList(locator).size();
	}

	public static List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	// 1.get total no.of links on the page
	public static int getPageElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}
