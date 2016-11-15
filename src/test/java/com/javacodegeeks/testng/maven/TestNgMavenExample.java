package com.javacodegeeks.testng.maven;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class TestNgMavenExample implements HomePageLocators{

	WebDriverWait wait=null;
	static AndroidDriver androidDriver=null;
	


	@BeforeTest
	public void beforeTest() throws MalformedURLException{
		
			DesiredCapabilities capabilities = new DesiredCapabilities();
			   
			  capabilities.setCapability("user", "is_user2@infostretch.com");
			  capabilities.setCapability("password", "Infostretch1");
			  capabilities.setCapability("deviceName", "FA53XYJ18894");
			  capabilities.setCapability("automationName", "Appium");
			  capabilities.setCapability("platformName", "Android");
			  capabilities.setCapability("appPackage", "com.flipkart.android");
			  capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
			  // androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			  androidDriver = new AndroidDriver(new URL("https://partners.perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
	
			androidDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			wait= new WebDriverWait(androidDriver, 20);
	}
	
	
	@Test
	public void exampleOfTestNgMaven() throws MalformedURLException, InterruptedException {

			Thread.sleep(10000);
			try {
				androidDriver.findElement(By.xpath("//*[@resource-id='com.flipkart.android:id/btn_skip']")).click();;
			} catch (Exception e) {
				System.out.println("Not found");
			}
			Thread.sleep(20000);
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='com.flipkart.android:id/search_widget_textbox']")));
		
			WebElement search=androidDriver.findElement(By.xpath("//*[@resource-id='com.flipkart.android:id/search_widget_textbox']"));
			waitforPresent(search,"30");
			search.click();
			search=androidDriver.findElement(By.xpath("//*[@resource-id='com.flipkart.android:id/search_autoCompleteTextView']"));
			search.sendKeys("watches");
			androidDriver.sendKeyEvent(66);
	
			WebElement title=androidDriver.findElement(By.xpath("//android.widget.TextView[@text='watches']"));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='watches']")));
			Assert.assertEquals(title.getText().equals("watches"), true);
	
	}
	
	
	public static void waitforPresent(WebElement element,String time){
		
		try {
			WebDriverWait wait =new WebDriverWait(androidDriver, Integer.parseInt(time));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element.toString())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
