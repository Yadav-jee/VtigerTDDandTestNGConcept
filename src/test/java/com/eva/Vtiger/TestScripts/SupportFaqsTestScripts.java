package com.eva.Vtiger.TestScripts;

import org.testng.annotations.Test;

public class SupportFaqsTestScripts {

	@Test(priority = 1)
	public void abc() 
	{
		int b = 2 / 0;

		System.out.println(" hello abc ");
	}

	@Test(priority = 3)
	public void Zbc()
	{
		System.out.println(" hello Zbc ");
	}

}
