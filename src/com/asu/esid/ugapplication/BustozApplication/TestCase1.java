package com.asu.esid.ugapplication.BustozApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.Assert;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.asu.esid.utilities.ReadPropertyFile;



public class TestCase1 
{
	ReadPropertyFile properties;
	WebDriver chromedriver;
	@BeforeClass
	 public void setUp() throws IOException 
	 {
		System.setProperty("webdriver.chrome.driver","C:\\Development\\ASUEnrollmentServices\\Automation\\lib\\chromedriver.exe");
		chromedriver = new ChromeDriver();
		properties = new ReadPropertyFile();
		String bustozURL = properties.getProperty("BustozURL");
		chromedriver.get(bustozURL);
	 }
	 
	@Test(priority=1,description="Launch Bustoz Application site: Login")
	public void launchSite() throws InterruptedException
	{
		  chromedriver. manage(). timeouts(). implicitlyWait(5, TimeUnit. SECONDS);
		  chromedriver.findElement(By.id("username")).sendKeys(properties.getProperty("Username"));
		  chromedriver.findElement(By.id("password")).sendKeys(properties.getProperty("Password"));
		  chromedriver.findElement(By.xpath("//input[@value='Sign In' and @type='submit']")).click();
		  chromedriver. manage(). timeouts(). implicitlyWait(5, TimeUnit. SECONDS);
		  Assert.assertEquals(chromedriver.getTitle(), "Arizona State University | Undergraduate Application");
	}
	
	@Test(priority=2,description="Search/Edit/Create Application: Load")
	public void loadSearchEditCreateApplications() throws InterruptedException
	{
		chromedriver.findElement(By.xpath("html/body/section/form/div/p[4]/label/a")).click();
		chromedriver. manage(). timeouts(). implicitlyWait(5, TimeUnit. SECONDS);
		Assert.assertEquals(chromedriver.getTitle(), "Arizona State University | Undergraduate Application | Search/Edit/Create Applications");
	}
	
	@Test(priority=2,description="Search/Edit/Create Application: Create")
	public void searchEditCreateApplication() throws InterruptedException
	{
		new Select (chromedriver.findElement(By.id("create_app_type"))).selectByValue("BUSTOZ");
		chromedriver. manage(). timeouts(). implicitlyWait(5, TimeUnit. SECONDS);
		chromedriver.findElement(By.id("admin-edit-app-new-application-button")).click();
		Assert.assertEquals(chromedriver.getTitle(), "Arizona State University | Undergraduate Application");
	}

	@AfterClass
	public void treminateBrowser()
	{
		chromedriver.quit();
	}

}
