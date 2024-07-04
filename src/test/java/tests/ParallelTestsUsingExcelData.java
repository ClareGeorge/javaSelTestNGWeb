package tests;

import org.testng.annotations.Test;

import resources.EComUtilsSeleniumWebApp;

public class ParallelTestsUsingExcelData extends EComUtilsSeleniumWebApp  {
	
	@Test(groups = {"Smoke"} )
	public void testOne() {
		System.out.println("I am testOne from ParallelTestsUsingExcelData");
	}
	@Test()
	public void testTwo() {
		System.out.println("I am testTwo from ParallelTestsUsingExcelData");
	}
}
