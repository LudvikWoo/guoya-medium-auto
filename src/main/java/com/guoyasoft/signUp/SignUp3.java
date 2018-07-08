package com.guoyasoft.signUp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.guoyasoft.common.BaseUI;

public class SignUp3 extends BaseUI{
	@FindBy(id="userName")
	WebElement userName ;
	
	@FindBy(id="realName")
	WebElement realName ;

	@FindBy(id="password")
	WebElement password ;
	
	@FindBy(id="password2")
	WebElement password2;
	
	@FindBy(xpath="//input[@id='submitBtn']")
	WebElement submitBtn ;

	
	@Test(dataProvider="signUpData")
	public void signUp2( String mark,String userNameValue, String realNameValue,
			String passwordValue, String password2Value, String weixinValue,
			String addressValue, String phoneValue, String ageValue,
			String educationValue, String classTypeValue,
			String checkCodeValue, String expectionValue,String isNeedBack) {
		
		text(userName, userNameValue);

		text(realName, realNameValue);

		text(password, passwordValue);

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
}
