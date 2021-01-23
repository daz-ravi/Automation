package general;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {

	@Test
	void test0()
	{
		System.out.println("At Test");
	}
	
	@BeforeSuite
	void test1()
	{
		System.out.println("BeforeSuite");
	}
	
	@AfterSuite
	void test2()
	{
		System.out.println("AfterSuite");
	}

	@BeforeTest
	void test3()
	{
		System.out.println("BeforeTest");
	}

	@AfterTest
	void test4()
	{
		System.out.println("AfterTest");
	}

	@BeforeGroups
	void test5()
	{
		System.out.println("BeforeGroups");
	}

	@AfterGroups
	void test6()
	{
		System.out.println("AfterGroups");
	}

	@BeforeClass
	void test7()
	{
		System.out.println("BeforeClass");
	}

	@AfterClass
	void test8()
	{
		System.out.println("AfterClass");
	}

	@BeforeMethod
	void test9()
	{
		System.out.println("BeforeMethod");
	}

	@AfterMethod
	void test10()
	{
		System.out.println("AfterMethod");
	}

}
