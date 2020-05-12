package day9;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class SampleWrapper extends MobileWrapper{
	
	@Test
	public void runLeafOrg() throws MalformedURLException {
		launchApp("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "OnePlus");
		
	}

}
