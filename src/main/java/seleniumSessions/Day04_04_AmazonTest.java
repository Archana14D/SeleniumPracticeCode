package seleniumSessions;

public class Day04_04_AmazonTest {

	public static void main(String[] args) {
		Day04_03BrowserUtil brUtil = new Day04_03BrowserUtil();
		brUtil.initDriver("chrome");
		// brUtil.launchUrl(null);
		//brUtil.launchUrl("https://www.amazon.com");
		 brUtil.launchUrl("");

//		if (brUtil.isUrlFractionExist("amazon")) {
//			System.out.println("url is correct.. PASS");
//		} else {
//			System.out.println("FAIL");
//		}

//		if (brUtil.isInfoExistInPageSource("https://completion.amazon.com")) {
//			System.out.println("PageSource is correct : Pass");
//		} else {
//			System.out.println("PageSource is incorrect : Fail");
//		}
//
//		if (brUtil.getPageTitle().contains("Spend less. Smile more.")) {
//			System.out.println("correct title");
//		} else {
//			System.out.println("Incorrect title");
//		}
		//brUtil.closeBrowser();
	}
}
