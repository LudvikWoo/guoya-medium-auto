package com.guoyasoft.common;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
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
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
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
	
	public void text(WebElement element,String text ){
		element.clear();
		element.sendKeys(text);
	}
	
	public void selectByText(WebElement element,String text){
		Select eduSelect=new Select(element);
		eduSelect.selectByVisibleText(text);
	}
	
	public void selectByValue(WebElement element,String value){
		Select eduSelect=new Select(element);
		eduSelect.selectByValue(value);
	}
	

	public void selectByIndex(WebElement element,int index){
		Select eduSelect=new Select(element);
		eduSelect.selectByIndex(index);
	}
	
	public void click(WebElement element){
		element.click();
	}
	
	public static void snapshot(TakesScreenshot drivername, String filename) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name

		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		try {
			System.out.println("save snapshot path is:" + filename);
			FileUtils.copyFile(scrFile, new File( filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished");
		}
	}
}
