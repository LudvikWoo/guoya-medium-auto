package com.guoyasoft.queryUser;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guoyasoft.common.BaseUI;

public class QueryUser extends BaseUI {
	@Test
	public void queryUser() {
		signUp();
		
//		login();

		query();
	}

	private void signUp() {
		// TODO Auto-generated method stub
		
	}

	private void login() {
		WebElement userName = driver.findElement(By.id("userName"));
		userName.clear();
		userName.sendKeys("wuling23");
		sleep(1000);

		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("qweasd");
		sleep(1000);

		WebElement checkCode = driver.findElement(By.id("checkCode"));
		checkCode.clear();
		checkCode.sendKeys("12345");
		sleep(1000);

		WebElement login = driver.findElement(By.id("loginBtn"));
		login.click();
		sleep(1000);

		boolean isSuccess = driver.getPageSource().contains("学生查询");
		Assert.assertEquals(isSuccess, true);
	}

	private void query() {
		WebElement userName = driver.findElement(By.name("realName"));
		text(userName, "吴令	");
		sleep(2000);
		
		String js="document.getElementsByName('startTime')[0].removeAttribute('readOnly');document.getElementsByName('startTime')[0].setAttribute('value','2018-07-05');";
//		String js="document.getElementsByName('startTime')[0].removeAttribute('readOnly');";

		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
        jsDriver.executeScript(js);
        /*
		WebElement startTime=driver.findElement(By.name("startTime"));
		text(startTime, "2018-07-05");*/
		sleep(2000);

		WebElement queryBtn = driver.findElement(By
				.xpath("//input[@type='submit' and @value='查询']"));
		click(queryBtn);
		/* sleep(2000); */
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.switchTo().frame("result");
		
		//改2个地方：1.改等待时间，2.apply方法的内容（返回boolean值）
		WebDriverWait wait = new WebDriverWait(driver, 3);
		boolean result = wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				boolean loadcomplete = driver.getPageSource().contains(
						"wuling23");
				System.out.println(new Date().getTime());
				System.out.println("loadcomplete=" + loadcomplete);
				return loadcomplete;
			}
		});
		
		Assert.assertEquals(result, true);
		sleep(2000);
	}
	
}
