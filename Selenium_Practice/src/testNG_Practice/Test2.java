package testNG_Practice;

import org.testng.annotations.Test;

public class Test2 {
	
	@Test(groups= {"sanity"})
	void from_Test()
	{
		System.out.println("From Test2");
	}
	
}
