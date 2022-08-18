package testngSessions;

import org.testng.annotations.Test;

public class Day02_02ExpectedExceptionConcept {

	//If there is any exception in a program, the test will get failed
	//It is not handling the exception, there is no try-catch block
	String name;
	
	
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void searchTest() {
		System.out.println("macbook");
		int i = 9/0;
		Day02_02ExpectedExceptionConcept obj = new Day02_02ExpectedExceptionConcept();
		obj = null;
		//obj.name = "Tom";//NPE
		System.out.println("bye");
	}
}
