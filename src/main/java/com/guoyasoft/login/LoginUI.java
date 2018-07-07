package com.guoyasoft.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guoyasoft.common.BaseUI;
import com.guoyasoft.tool.CSVReader;

public class LoginUI extends BaseUI{
	@Test
	public void login(){
		WebElement userName=driver.findElement(By.id("userName"));
		userName.clear();
		userName.sendKeys("wuling23");
		sleep(1000);
		
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("qweasd");
		sleep(1000);
		
		WebElement checkCode=driver.findElement(By.id("checkCode"));
		checkCode.clear();
		checkCode.sendKeys("12345");
		sleep(1000);
		
		WebElement login=driver.findElement(By.id("loginBtn"));
		login.click();
		sleep(1000);
		
		/*String title=driver.getTitle();
		String url=driver.getCurrentUrl();*/
		String content=driver.getPageSource();
		
		boolean isSuccess=content.contains("学生查询");
		Assert.assertEquals(isSuccess, true);
	}
	
	@Test(dataProvider="loginCase")
	public void supperLogin(String userNameValue,String passwordValue,String checkCodeValue,String asserValue,String mark){
		WebElement userName=driver.findElement(By.id("userName"));
		userName.clear();
		userName.sendKeys(userNameValue);
		sleep(1000);
		
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys(passwordValue);
		sleep(1000);
		
		WebElement checkCode=driver.findElement(By.id("checkCode"));
		checkCode.clear();
		checkCode.sendKeys(checkCodeValue);
		sleep(1000);
		
		WebElement login=driver.findElement(By.id("loginBtn"));
		login.click();
		sleep(1000);
		
		/*String title=driver.getTitle();
		String url=driver.getCurrentUrl();*/
		String content=driver.getPageSource();
		
		boolean isSuccess=content.contains(asserValue);
		Assert.assertEquals(isSuccess, true);
		driver.navigate().back();
		sleep(1000);
	}
	
	@DataProvider(name="loginCase")
	public Object[][] getLoginCase(){
		Object[][] data=CSVReader.readCSV("Z:\\12_测试培训\\汇总_05_果芽开发\\11_2018-06-09-中级班\\第四周_界面自动化_2018-07-07\\login_test_case_2018-07-07.csv");
		return data;
	}
}
