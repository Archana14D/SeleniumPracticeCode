package seleniumSessions;

import org.openqa.selenium.By;

public class Day11_01CustomXpath {

	public static void main(String[] args) {

		// xpath is an attribute, its an address of the element in the DOM
		// 1.absolute xpath: /html/div/div[2]/div[3]/div/ul/li[2]/a
			// starts with single slash
			// If any of the element gets changed, whole xpath will be changed and won't work
		// 2.relative/custom xpath: with the help of attributes, xpath functions
			// starts with double slash

		// Single attribute:
			// htmltag[@attr='value']
				// input[@id='input-email']
				// input[@name='email']
			// Multi-attribute:
			// htmltag[@attr1='value1' and @attr2 = 'value2']
				//input[@id='input-email' and @name='email']
				//input[@id='input-email' and @name='email' and @class='form-control']
			//We can use or as well. 'and' means all conditions should be satisfied, 'or' means any of the condition should be satisfied	
				//input[@id='input-email' or @name='email']
		
		//valid tags:
			//input
			//a : it will find all the links on a page
			//input[@id] : find all the input where id is available
		
		//text():
			//htmltag[text()='value']
			//a[text()='Login']   //It will find all the links having text as Login
			//label[text()='First Name']
		
		//contains(): used it for dynamic elements
			//htmltag[contains(@attr,'value')]

//input[contains(@id,'firstname')]
		
//		input <id = test_123>
//		<id = test_345>
//		<id = firstname_abc>
//		<id = firstname_abcdff>
//		<id = firstname_abc123>
		
		By.id("test_123");//Not recommended
		By.xpath("//input[contains(@id,'test_')]");
		By.xpath("//input[contains(@id,'firstname_')]");
		
		//htmltag[contains(@attr,'value') and contains(@attr,'value')]
		//input[contains(@id,'firstname') and contains(@name,'first')]
		//input[contains(@id='input-firstname')] --Invalid xpath
		
		//input[contains(@id,'firstname') and @name='firstname']
		//input[contains(@id,'firstname') and @name='firstname' and @type='text']
		
		//contains() with text():
		//htmltag[contains(text(),'value')]
		//h2[contains(text(),'Delight')]
		
		//contains() with text() and with attribute:
		//htmltag[contains(text(),'value') and contains(@attr,'value')]
		//a[contains(text(),'Customers') and contains(@href,'customers')]
		
		//htmltag[contains(text(),'value') and contains(@attr,'value') and @attr='value']
		
		//starts-with():
		//htmltag[starts-with(@attr,'value')]
		//p[starts-with(text(),'If you already')]
		
		//ends-with():deprecated in xpath3.0
		
		//index:
		// (//input[@class='form-control'])[6]
		// (//input[@class='form-control'])[position()=6]
		By.xpath("(//input[@class='form-control'])[6]");
		
		// (//input[@class='form-control'])[last()]
		// (//input[@class='form-control'])[last()-5]
		
		// ((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]
		
		By.xpath("((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]");

			}

}
