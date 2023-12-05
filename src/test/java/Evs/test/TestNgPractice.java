package Evs.test;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestNgPractice {

	@Test(priority = 2, alwaysRun = true, groups = { "smoke" })
	public void m1() {
		System.out.println("m1");
	}

//	@Test(priority = 1, alwaysRun = true, dependsOnMethods = { "m1" })
//	public void m2() {
//		Assert.assertEquals("11", "13");
//		System.out.println("m2");
//	}

	@BeforeGroups({ "sanity" })
	@Test
	public void m3() {
		System.out.println("m3");
	}

	@Test(priority = 4)
	public void m4() {
//		System.out.println(15 / 0);
		System.out.println("m4");
	}

}
