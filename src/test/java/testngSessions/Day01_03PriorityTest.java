package testngSessions;

import org.testng.annotations.Test;

public class Day01_03PriorityTest {
	
	//priority is a pre-define int variable
	//less no. of the priority, more weightage to the test case. priority 1 > priority 5
	//we can have priority = 0, it will be executed first out of 0 to 5
	//we can have negative priority as well, it will get executed first (e.g. -5, -3,-1, 1, 3)
	//negative, then zero, then positive
	// we can have same priority for 2 test cases, in that case, alphabetical order will be considered
	//If we have with and without priority test cases, then without priority will get executed first and the with priority
	
	
	@Test(priority = 5)
	public void a_test() {
		System.out.println("a test");
	}

	@Test(priority = 1)
	public void b_test() {
		System.out.println("b test");
	}

	@Test
	public void c_test() {
		System.out.println("c test");
	}

	@Test
	public void d_test() {
		System.out.println("d test");
	}

	@Test(priority = 3)
	public void e_test() {
		System.out.println("e test");
	}

}
