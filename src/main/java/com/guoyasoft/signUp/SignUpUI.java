package com.guoyasoft.signUp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guoyasoft.common.BaseUI;
import com.guoyasoft.tool.CSVReader;

public class SignUpUI extends BaseUI {

	@Test
	public void signUp() {
		WebElement userName = driver.findElement(By.id("userName"));
		text(userName, "guoya1");

		WebElement realName = driver.findElement(By.id("realName"));
		text(realName, "果芽软件a");

		WebElement password = driver.findElement(By.id("password"));
		text(password, "aaabbb");

		WebElement password2 = driver.findElement(By.id("password2"));
		text(password2, "aaabbb");

		WebElement weixin = driver.findElement(By.id("weixin"));
		text(weixin, "234324");

		WebElement address = driver.findElement(By.id("address"));
		text(address, "上海闵行");

		WebElement phone = driver.findElement(By.id("phone"));
		text(phone, "12345678901");

		WebElement age = driver.findElement(By.id("age"));
		text(age, "32");

		WebElement education = driver.findElement(By.id("education"));
		selectByText(education, "本科");

		WebElement classType = driver.findElement(By.id("classType"));
		selectByText(classType, "提高班");

		WebElement checkCode = driver.findElement(By
				.xpath("//input[@id='checkCode']"));
		text(checkCode, "1234");

		WebElement submitBtn = driver.findElement(By
				.xpath("//input[@id='submitBtn']"));
		click(submitBtn);
		sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.accept();
		sleep(2000);

		boolean result = driver.getPageSource().contains("登录界面");
		Assert.assertEquals(result, true);
	}

	@Test(dataProvider="signUpData")
	public void signUp2( String mark,String userNameValue, String realNameValue,
			String passwordValue, String password2Value, String weixinValue,
			String addressValue, String phoneValue, String ageValue,
			String educationValue, String classTypeValue,
			String checkCodeValue, String expectionValue,String isNeedBack) {
		WebElement userName = driver.findElement(By.id("userName"));
		text(userName, userNameValue);

		WebElement realName = driver.findElement(By.id("realName"));
		text(realName, realNameValue);

		WebElement password = driver.findElement(By.id("password"));
		text(password, passwordValue);

		WebElement password2 = driver.findElement(By.id("password2"));
		text(password2,password2Value);

		WebElement weixin = driver.findElement(By.id("weixin"));
		text(weixin, weixinValue);

		WebElement address = driver.findElement(By.id("address"));
		text(address, addressValue);

		WebElement phone = driver.findElement(By.id("phone"));
		text(phone, phoneValue);

		WebElement age = driver.findElement(By.id("age"));
		text(age, ageValue);

		WebElement education = driver.findElement(By.id("education"));
		selectByText(education, educationValue);

		WebElement classType = driver.findElement(By.id("classType"));
		selectByText(classType, classTypeValue);

		WebElement checkCode = driver.findElement(By
				.xpath("//input[@id='checkCode']"));
		text(checkCode, checkCodeValue);

		WebElement submitBtn = driver.findElement(By
				.xpath("//input[@id='submitBtn']"));
		click(submitBtn);
		sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.accept();
		sleep(2000);

		snapshot((TakesScreenshot)driver, "C:\\test\\"+userNameValue+".jpg");
		
		boolean result = driver.getPageSource().contains(expectionValue);
		Assert.assertEquals(result, true);
		sleep(2000);
		if("TRUE".equals(isNeedBack)){
			driver.navigate().back();
		}
	}

	@DataProvider(name="signUpData")
	public Object[][] getSignUpData(){
		return CSVReader.readCSV("Z:\\12_测试培训\\汇总_05_果芽开发\\11_2018-06-09-中级班\\第四周_界面自动化_2018-07-07\\signUp_test_case_2018-07-07.csv");
	}
}
