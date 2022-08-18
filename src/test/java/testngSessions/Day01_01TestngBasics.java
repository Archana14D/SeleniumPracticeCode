package testngSessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//testNG: java unit testing fw
	// global pre condition
	// pre condition
	// test steps (test cases) + exp result vs act result --> PASS/FAIL
	// post steps

/**
 * 
BS - Connect with DB
BT - Create User
BC - launch Browser

BM - login
add to cart test
AM - After Method - Logout

BM - login
home page test
AM - After Method - Logout

BM - login
search page test
AM - After Method - Logout

AC - close Browser
AC - delete User
AS - disconnectWithDB

 * @author vikas
 *
 */


//tests will get executed alphabetically
//If we comment all @Test annotations or we do not write any @Test annotations, the program will not get executed, It says, No tests found. Nothing was run


public class Day01_01TestngBasics {

	@BeforeSuite
	public void connectWithDB() {
		System.out.println("BS - Connect with DB");
	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("BT - Create User");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC - launch Browser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("BM - login");
	}
	
	
	//It is always a good practice to write any test name ends with 'test'
	@Test
	public void homePageTest() {
		System.out.println("home page test");
	}
		
	@Test
	public void searchPageTest() {
		System.out.println("search page test");
	}
		
	@Test
	public void addToCartTest() {
		System.out.println("add to cart test");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("AM - After Method - Logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC - close Browser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AC - delete User");
	}
	
	@AfterSuite
	public void disconnectWithDB() {
		System.out.println("AS - disconnectWithDB");
	}
	
	
}
