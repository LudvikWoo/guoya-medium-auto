package com.guoyasoft.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseUI {
	public WebDriver driver;
	
	@BeforeTest
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver",
				"src/main/resources/selenium/driver_v236_63_65/chromedriver.exe");
		// 设置浏览器的参数
		ChromeOptions options = new ChromeOptions();
		// 最大化浏览器
		options.addArguments("--test-type", "--start-maximized");
		// options.setBinary("C:/XXXXXXX/chrome.exe");
		// 打开浏览器
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		sleep(1000);
	}
	
	@AfterTest
	public void closeChrome(){
		driver.quit();
	}
	
	@Test
	@Parameters({"url"})
	public void openUrl(String url){
		driver.get(url);
		sleep(1000);
	}
	
	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
