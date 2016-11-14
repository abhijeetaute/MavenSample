package com.javacodegeeks.testng.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestNgMavenSecondClass {

	@Test
	public void oneMoreTest() throws InterruptedException {
	
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Abhijeet Aute");
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("btnG")).click();
	}
}
