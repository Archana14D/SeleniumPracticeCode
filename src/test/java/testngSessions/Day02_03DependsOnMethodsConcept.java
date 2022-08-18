package testngSessions;

import org.testng.annotations.Test;

public class Day02_03DependsOnMethodsConcept {

	
	// dependsOnMethods - It gives lot of issues in case of parellel execution
	
	
	@Test
	public void loginTest() {
		System.out.println("login test");
		int i = 9 / 0;
	}

	@Test(dependsOnMethods = "loginTest") // First loginTest() will get executed and then homeTest. 
										  //If loginTest() fails, then homeTest will not get executed,
										//it will get skipped
	public void homeTest() {
		System.out.println("home test");
	}
}
